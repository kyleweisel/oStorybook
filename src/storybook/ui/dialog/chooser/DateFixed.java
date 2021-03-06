/*
 * SbApp: Open Source software for novelists and authors.
 * Original idea 2008 - 2012 Martin Mustun
 * Copyrigth (C) Favdb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package storybook.ui.dialog.chooser;

import java.awt.Component;

/**
 *
 * @author favdb
 */
public class DateFixed extends javax.swing.JPanel {
	private Component parent;

	/**
	 * Creates new form DateFixed
	 */
	public DateFixed() {
		initComponents();
	}

	public DateFixed(Component m) {
		initComponents();
		parent=m;
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btFirst = new javax.swing.JButton();
        btPrevious = new javax.swing.JButton();
        btNext = new javax.swing.JButton();
        btLast = new javax.swing.JButton();
        lbDate = new javax.swing.JLabel();
        dateSpinner = new javax.swing.JSpinner();
        btClearDate = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();
        btClearTime = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/first.png"))); // NOI18N
        btFirst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/previous.png"))); // NOI18N
        btPrevious.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/next.png"))); // NOI18N
        btNext.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/last.png"))); // NOI18N
        btLast.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/msg/messages"); // NOI18N
        lbDate.setText(bundle.getString("msg.common.date")); // NOI18N

        btClearDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/clear.png"))); // NOI18N
        btClearDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbTime.setText(bundle.getString("msg.common.time")); // NOI18N

        btClearTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/clear.png"))); // NOI18N
        btClearTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbTime)
                        .addGap(6, 6, 6)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClearTime))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLast))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btClearDate)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btNext)
                    .addComponent(btLast)
                    .addComponent(btFirst)
                    .addComponent(btPrevious))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate)
                    .addComponent(btClearDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClearTime)
                    .addComponent(lbTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClearDate;
    private javax.swing.JButton btClearTime;
    private javax.swing.JButton btFirst;
    private javax.swing.JButton btLast;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btPrevious;
    private javax.swing.JSpinner dateSpinner;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTime;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables
}
