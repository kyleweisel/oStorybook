package edu.drexel.se410;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.Triple;
import storybook.model.hbn.entity.Category;
import storybook.model.hbn.entity.Gender;
import storybook.model.hbn.entity.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class is responsible for generating Person objects from the contents of a text file
 */
public final class PersonFactory {

    public static final String SPACE = " ";

    public final List<Person> extractPersonsFromFile(final String file) {

        final String serializedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz";
        final List<Person> result = new ArrayList<Person>();
        final KGenderizer genderizer = new KGenderizer();

        try {

            final AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);
            final String fileContents = IOUtils.slurpFile(file);
            final List<Triple<String, Integer, Integer>> list = classifier.classifyToCharacterOffsets(fileContents);
            final HashSet<String> existingNames = new HashSet<String>();

            for (final Triple<String, Integer, Integer> item : list) {

                if (item.first().equals("PERSON")) {

                    String name = fileContents.substring(item.second(), item.third());
                    name = name.replace("\n", SPACE).replace("\r", SPACE).replaceAll("\\s+", SPACE).trim();

                    if (!existingNames.contains(name)) {

                        existingNames.add(name);

                        final String[] names = name.split(SPACE);

                        /*
                            Create and configure the person object here...
                         */
                        final Person person = new Person();
                        final Gender gender = new Gender();

                        String abbreviation = names[0].substring(0, 2);

                        person.setFirstname(names[0]);

                        if(names.length > 1) {
                            person.setLastname(names[1]);
                            abbreviation += names[1].substring(0, 2);
                        }

                        person.setAbbreviation(abbreviation);

                        final String strGender = genderizer.getGender(person.getFirstname());
                        gender.setId(strGender.equals(KGenderizer.FEMALE) ? 2L : 1L);
                        person.setGender(gender);

                        final Category category = new Category();
                        category.setId(1L);

                        person.setCategory(category);

                        result.add(person);
                    }

                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

}
