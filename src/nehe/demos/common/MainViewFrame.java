/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nehe.demos.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ROMAN
 */
public class MainViewFrame extends javax.swing.JFrame {

//    ConfParmSubsystem.AppContext appContext = ConfParmSubsystem.getInstance().getCtxt();

    /**
     * Creates new form TestFrame
     */
    public MainViewFrame() {
        initComponents();
        firstX.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        firstY.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        firstZ.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        secondX.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        secondY.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        secondZ.setModel(new SpinnerNumberModel(0, -2000, 2000, 0.2));
        jSpinner1.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (((Integer) jSpinner1.getValue()) % 360 == 0) {
                    jSpinner1.setValue(0);
                }
                MirrorTest.angleFirst = (Integer) jSpinner1.getValue();
            }
        });

        jSpinner2.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (((Integer) jSpinner2.getValue()) % 360 == 0) {
                    jSpinner2.setValue(0);
                }
                MirrorTest.angleSecond = (Integer) jSpinner2.getValue();
            }
        });

        jSpinner3.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (((Integer) jSpinner3.getValue()) % 360 == 0) {
                    jSpinner3.setValue(0);
                }
                MirrorTest.angleThird = (Integer) jSpinner3.getValue();
            }
        });
        jSpinner4.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (((Integer) jSpinner4.getValue()) % 360 == 0) {
                    jSpinner4.setValue(0);
                }
                MirrorTest.angleMirror = (Integer) jSpinner4.getValue();
            }
        });
//        firstX.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.firstPoint.x = (float)((double)  firstX.getValue());
//            }
//        });
//        firstY.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.firstPoint.y = (float)((double) firstY.getValue());
//            }
//        });
//        firstZ.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.firstPoint.z = (float)((double)  firstZ.getValue());
//            }
//        });
//
//        secondX.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.secondPoint.x = (float)((double)  secondX.getValue());
//            }
//        });
//        secondY.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.secondPoint.y = (float)((double) secondY.getValue());
//            }
//        });
//        secondZ.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                appContext.secondPoint.z = (float)((double) secondZ.getValue());
//            }
//        });

        Timer timer = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstLeft.isSelected()) {
                    jSpinner1.setValue(((Integer) jSpinner1.getValue()) - 1);
                }
                if (firstRight.isSelected()) {
                    jSpinner1.setValue(((Integer) jSpinner1.getValue()) + 1);
                }
                if (secondLeft.isSelected()) {
                    jSpinner2.setValue(((Integer) jSpinner2.getValue()) - 1);
                }
                if (secondRight.isSelected()) {
                    jSpinner2.setValue(((Integer) jSpinner2.getValue()) + 1);
                }
                if (ThirdLeft.isSelected()) {
                    jSpinner3.setValue(((Integer) jSpinner3.getValue()) - 1);
                }
                if (thirdRight.isSelected()) {
                    jSpinner3.setValue(((Integer) jSpinner3.getValue()) + 1);
                }
                if (planeLeft.isSelected()) {
                    jSpinner4.setValue(((Integer) jSpinner4.getValue()) - 1);
                }
                if (planeRight.isSelected()) {
                    jSpinner4.setValue(((Integer) jSpinner4.getValue()) + 1);
                }
            }
        });
        timer.start();
    }

    public void changeMirrorDirection(){
        if(planeRight.isSelected()){
            jSpinner4.setValue((Integer)jSpinner4.getValue() - 3);
            planeRight.setSelected(false);
            planeLeft.setSelected(true);
        }else if(planeLeft.isSelected()){
                  jSpinner4.setValue((Integer)jSpinner4.getValue() + 3);
            planeRight.setSelected(true);
            planeLeft.setSelected(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstLeft = new javax.swing.JToggleButton();
        firstRight = new javax.swing.JToggleButton();
        secondRight = new javax.swing.JToggleButton();
        secondLeft = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        thirdRight = new javax.swing.JToggleButton();
        ThirdLeft = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        planeRight = new javax.swing.JToggleButton();
        planeLeft = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        firstX = new javax.swing.JSpinner();
        firstY = new javax.swing.JSpinner();
        firstZ = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        secondX = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        secondY = new javax.swing.JSpinner();
        secondZ = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Вращать первый кубоид");

        firstLeft.setText("<<");
        firstLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstLeftActionPerformed(evt);
            }
        });

        firstRight.setText(">>");
        firstRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstRightActionPerformed(evt);
            }
        });

        secondRight.setText(">>");
        secondRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondRightActionPerformed(evt);
            }
        });

        secondLeft.setText("<<");
        secondLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondLeftActionPerformed(evt);
            }
        });

        jLabel2.setText("Вращать второй кубоид");

        thirdRight.setText(">>");
        thirdRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdRightActionPerformed(evt);
            }
        });

        ThirdLeft.setText("<<");
        ThirdLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThirdLeftActionPerformed(evt);
            }
        });

        jLabel3.setText("Вращать третий кубоид");

        planeRight.setText(">>");
        planeRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeRightActionPerformed(evt);
            }
        });

        planeLeft.setText("<<");
        planeLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeLeftActionPerformed(evt);
            }
        });

        jLabel4.setText("Зеркало");

        jLabel5.setText("Первая точка плоскости");

        firstX.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        firstY.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        firstZ.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        jLabel6.setText("X");

        jLabel7.setText("Y");

        jLabel8.setText("Z");

        jLabel9.setText("Вторая точка плоскости");

        jLabel10.setText("X");

        secondX.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(0.0f)));

        jLabel11.setText("Y");

        secondY.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        secondZ.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondRight)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(planeLeft)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(planeRight))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ThirdLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdRight)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstRight))))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstZ, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(secondX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(secondY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(secondZ, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstLeft)
                            .addComponent(firstRight)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secondLeft)
                            .addComponent(secondRight)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThirdLeft)
                            .addComponent(thirdRight)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(planeLeft)
                            .addComponent(planeRight)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secondX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstLeftActionPerformed

    private void firstRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstRightActionPerformed

    private void secondRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondRightActionPerformed

    private void secondLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondLeftActionPerformed

    private void thirdRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdRightActionPerformed

    private void ThirdLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThirdLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThirdLeftActionPerformed

    private void planeRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planeRightActionPerformed

    private void planeLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planeLeftActionPerformed

    public void setGLCanvas(GLCanvas canvas) {
        jPanel1.add(canvas);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ThirdLeft;
    private javax.swing.JToggleButton firstLeft;
    private javax.swing.JToggleButton firstRight;
    private javax.swing.JSpinner firstX;
    private javax.swing.JSpinner firstY;
    private javax.swing.JSpinner firstZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JToggleButton planeLeft;
    private javax.swing.JToggleButton planeRight;
    private javax.swing.JToggleButton secondLeft;
    private javax.swing.JToggleButton secondRight;
    private javax.swing.JSpinner secondX;
    private javax.swing.JSpinner secondY;
    private javax.swing.JSpinner secondZ;
    private javax.swing.JToggleButton thirdRight;
    // End of variables declaration//GEN-END:variables
}
