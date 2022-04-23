/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ListaCircularDobleServicios.ListaCircularDoble;
import ListaCircularDobleServicios.NodoLCD;
import ListaCircularEjecutivo.ListaCircularSimple;
import ListaCircularEjecutivo.NodoLCS;
import ListaDobleAtencionC.AtencionC;
import ListaDobleAtencionC.ListaDoble;
import ListaUsuarios.ListaSimple;
import ListaUsuarios.Nodo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ramos
 */
public class Atencionalcliente extends javax.swing.JFrame {

    /**
     * Creates new form Atencionalcliente
     */
    public Atencionalcliente() {
        initComponents();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Prioridad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton1.setText("Actualizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ejecutivo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Atender");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ejecutivo", "Servicio", "Cliente", "Servicio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ListaSimple LS = new ListaSimple();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("usuario.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaSimple vLS = (ListaSimple) input.readObject();
            input.close();
            LS = vLS;
            miArchivo2.close();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());

        }
        ListaCircularSimple LCS = new ListaCircularSimple();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Ejecutivo.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaCircularSimple vLCS = (ListaCircularSimple) input.readObject();
            input.close();
            LCS = vLCS;
            miArchivo2.close();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());

        }
        this.mostrarLC(LCS);
        this.mostrarC(LS);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        ListaSimple LS = new ListaSimple();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("usuario.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaSimple vLS = (ListaSimple) input.readObject();
            input.close();
            LS = vLS;
            miArchivo2.close();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        Nodo Usuario = LS.getPrimero();
        ListaCircularSimple LCS = new ListaCircularSimple();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Ejecutivo.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaCircularSimple vLCS = (ListaCircularSimple) input.readObject();
            input.close();
            LCS = vLCS;
            miArchivo2.close();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        NodoLCS actual = LCS.getPrimero();
        NodoLCS Ejecutivo = null;
        do {
            if (actual.getEjecutivo().getEstado().equals("Disponible")) {
                Ejecutivo = actual;
                actual.getEjecutivo().setEstado("Ocupado");
                try {
                    FileOutputStream miArchivo = new FileOutputStream("Ejecutivo.su");
                    ObjectOutputStream output = new ObjectOutputStream(miArchivo);
                    output.writeObject(LCS);
                    output.close();
                    miArchivo.close();
                    JOptionPane.showMessageDialog(null, "Se registró correctamente en el Ejecutivo");
                    LCS.listar();

                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
                LS.RMPrimero();
                try {
                    FileOutputStream miArchivo = new FileOutputStream("usuario.su");
                    ObjectOutputStream output = new ObjectOutputStream(miArchivo);
                    output.writeObject(LS);
                    output.close();
                    miArchivo.close();
                    JOptionPane.showMessageDialog(null, "Se registró correctamente el usuario");
                    LS.listar();

                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
                this.mostrarLC(LCS);
                this.mostrarC(LS);
                actual = LCS.getPrimero();
            } else {
                actual = actual.getSiguiente();
            }
        } while (actual != LCS.getPrimero());
        ListaCircularDoble LCD = new ListaCircularDoble();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Servicios.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaCircularDoble vLCD = (ListaCircularDoble) input.readObject();
            input.close();
            miArchivo2.close();
            LCD = vLCD;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        NodoLCD aux = LCD.getPrimero();
        NodoLCD Servicio = null;
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        String fyh = "" + dtf3.format(LocalDateTime.now());
        do {
            if (aux.getServicios().getNombre().equals(Usuario.getUsuario().getTipodeTransaccion())) {
                Servicio = aux;
            }

            aux = aux.getSiguiente();
        } while (aux != LCD.getPrimero());
        aux = LCD.getPrimero();
        do {
            if (aux.getServicios().getCodigo() == 1000) {
                Servicio = aux;
            }

            aux = aux.getSiguiente();
        } while (aux != LCD.getPrimero());
        ListaDoble LD = new ListaDoble();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Atencion.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaDoble vLD = (ListaDoble) input.readObject();
            input.close();
            miArchivo2.close();
            LD = vLD;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        LD.insertarFInal(new AtencionC(Usuario.getUsuario(), Ejecutivo.getEjecutivo(), fyh, Servicio.getServicios()));
        try {
            FileOutputStream miArchivo = new FileOutputStream("Atencion.su");
            ObjectOutputStream output = new ObjectOutputStream(miArchivo);
            output.writeObject(LD);
            output.close();
            miArchivo.close();
            JOptionPane.showMessageDialog(null, "Se registró correctamente el tramite");
            LD.listarAdelante();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Atencion.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaDoble vLD = (ListaDoble) input.readObject();
            input.close();
            miArchivo2.close();
            LD = vLD;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        this.mostrarLD(LD);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Atencionalcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencionalcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencionalcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencionalcliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencionalcliente().setVisible(true);
            }
        });
    }

    public void mostrarC(ListaSimple LS) {
        String matriz[][] = new String[LS.getCantNodos()][2];
        for (int i = 0; i < LS.getCantNodos(); i++) {
            matriz[i][0] = LS.getPrimero().getUsuario().getName() + " " + LS.getPrimero().getUsuario().getApellido();
            matriz[i][1] = LS.getPrimero().getUsuario().getPrioridad();
            LS.setPrimero(LS.getPrimero().getSiguiente());
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Nombre", "Prioridad"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    public void mostrarLD(ListaDoble LD) {
        String matriz[][] = new String[LD.getCantNodos()][4];
        for (int i = 0; i < LD.getCantNodos(); i++) {
            matriz[i][0] = LD.getPrimero().getAtencionC().getEjecutivo().getNombre();
            matriz[i][1] = LD.getPrimero().getAtencionC().getUsuario().getName();
            matriz[i][2] = LD.getPrimero().getAtencionC().getServicio().getNombre();
            matriz[i][3] = LD.getPrimero().getAtencionC().getFechayHora();
            LD.setPrimero(LD.getPrimero().getSiguiente());
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Ejecutivo", "Cliente", "Servicio", "Fecha"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    public void mostrarLC(ListaCircularSimple LCS) {
        String matriz[][] = new String[LCS.getCantNodos()][2];
        for (int i = 0; i < LCS.getCantNodos(); i++) {
            matriz[i][0] = LCS.getPrimero().getEjecutivo().getNombre();
            matriz[i][1] = LCS.getPrimero().getEjecutivo().getEstado();
            LCS.setPrimero(LCS.getPrimero().getSiguiente());
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Nombre", "Estado"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
