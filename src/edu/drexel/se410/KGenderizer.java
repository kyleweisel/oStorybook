package edu.drexel.se410;

import org.json.JSONObject;

import java.net.MalformedURLException;

public class KGenderizer {

    public static final String FEMALE = "female";
    public static final String MALE = "male";

    public final String getGender(final String name) {

        try {

            final SimpleRESTClient client = new SimpleRESTClient();
            final ResponseWrapper rw = client.makeRequest("https://api.genderize.io/?name=" + name);

            if (!rw.isError()) {

                final JSONObject response = new JSONObject(rw.response);
                final String gender = (response.isNull("gender") ? this.getRandomGender() : response.optString("gender"));
                final double probability = response.optDouble("probability");

                return gender;

            }


        } catch (MalformedURLException exception) {
            System.out.println("getGender() -> Caught MalformedURLException.  It said: " + exception.getMessage());
        }

        return null;

    }

    private String getRandomGender() {
        return (Math.random() > .5) ? FEMALE : MALE;
    }

}
