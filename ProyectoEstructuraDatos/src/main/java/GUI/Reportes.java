/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Arboltransferencias.Arbol;
import Arboltransferencias.NodoArbol;
import ColaSucursales.Cola;
import ColaSucursales.Nodo;
import ListaCircularEjecutivo.ListaCircularSimple;
import ListaCircularEjecutivo.NodoLCS;
import ReportesPila.Pila;
import ReportesPila.nodoPila;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jose Ramos
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CBsucursal = new javax.swing.JComboBox<>();
        CBdia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtejecutivo = new javax.swing.JLabel();
        txtdia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vista de Reportes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(43, 56, 97));

        DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>();
        Cola cola = new Cola();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Sucursal.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            Cola vcola = (Cola) input.readObject();
            input.close();
            cola = vcola;
            miArchivo2.close();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());

        }
        model.addElement("Todos");
        Nodo actual = cola.getFrente();
        if (cola.EsVacia()) {
            System.out.println("Lista vacia");
        } else {
            do {
                model.addElement(actual.getSucursal().getNomSu());
                actual = actual.getSiguiente();
            } while (actual != null);
        }
        CBsucursal.setBackground(new java.awt.Color(255, 255, 255));
        CBsucursal.setForeground(new java.awt.Color(5, 12, 24));
        CBsucursal.setModel(model);

        DefaultComboBoxModel<String> model2=new DefaultComboBoxModel<String>();

        Arbol arbol2 = new Arbol();
        Pila pila1 = new Pila();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Transferencia.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            Arbol varbol2 = (Arbol) input.readObject();
            input.close();
            miArchivo2.close();
            arbol2 = varbol2;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        pila1 = arbol2.ArbolPila();
        nodoPila aux1 = pila1.getInicio();
        model2.addElement("Todos");
        if (pila1.EsVacia()) {
            System.out.println("LA pila esta vacia");
        } else {

            while (aux1 != null) {
                if(aux1.getSiguiente()!=null){
                    if (!aux1.getDato().getFechayHora().substring(0, 13).equals(aux1.getSiguiente().getDato().getFechayHora().substring(0, 13))) {
                        model2.addElement(aux1.getDato().getFechayHora().substring(0, 13));
                    }
                }else{
                    if(aux1.getSiguiente()==null){
                        model2.addElement(aux1.getDato().getFechayHora().substring(0, 13));
                    }
                }
                aux1= aux1.getSiguiente();
            }
        }
        CBdia.setBackground(new java.awt.Color(255, 255, 255));
        CBdia.setForeground(new java.awt.Color(5, 12, 24));
        CBdia.setModel(model2);

        jTable1.setBackground(new java.awt.Color(5, 12, 24));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ejecutivo", "Usuario", "Servicio", "Fecha"
            }
        ));
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(5, 12, 24));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total de casos");

        txttotal.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Promedio de casos por Ejecutivo");

        txtejecutivo.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        txtejecutivo.setForeground(new java.awt.Color(255, 255, 255));

        txtdia.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        txtdia.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Promedio de casos por dia");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sucursal");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CBdia, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtejecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(txttotal)
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtejecutivo)
                            .addComponent(txtdia)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Arbol arbol = new Arbol();
        int contid = 0;
        Pila pila = new Pila();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Transferencia.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            Arbol varbol = (Arbol) input.readObject();
            int vcontid = (int) input.readObject();
            input.close();
            miArchivo2.close();
            arbol = varbol;
            contid = vcontid;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        pila = arbol.ArbolPila();
        mostrarP(pila);
    }//GEN-LAST:event_jButton1MouseClicked
    public DefaultComboBoxModel<String> ArbolFeechas(NodoArbol nodo, Arbol arbol, DefaultComboBoxModel<String> model2) {
        if (nodo != null) {
            ArbolFeechas(nodo.getHijoizq(), arbol, model2);
            if (nodo.getHijoder() != null) {
                if (nodo.getTransferencia().getFechayHora().substring(0, 12).equals(nodo.getHijoder().getTransferencia().getFechayHora().substring(0, 13))) {
                    model2.addElement(nodo.getTransferencia().getFechayHora().substring(0, 12));
                }
            }
            ArbolFeechas(nodo.getHijoder(), arbol, model2);
        }
        return model2;
    }

    public void mostrarP(Pila pila) {

        String matriz[][] = new String[pila.getSize()][4];
        nodoPila aux = pila.getInicio();
        int i = 0;
        double q=0;
        while (aux != null) {
            if (CBsucursal.getSelectedItem().toString().equals("Todos") && CBdia.getSelectedItem().toString().equals("Todos")) {
                matriz[i][0] = aux.getDato().getEjecutivo().getNombre();
                matriz[i][1] = aux.getDato().getUsuario().getName();
                matriz[i][2] = aux.getDato().getServicio().getNombre();
                matriz[i][3] = aux.getDato().getFechayHora();

                i++;
            } else if (!CBsucursal.getSelectedItem().toString().equals("Todos") && CBdia.getSelectedItem().toString().equals("Todos")) {
                if (aux.getDato().getEjecutivo().getSucursal().equals(CBsucursal.getSelectedItem().toString())) {
                    matriz[i][0] = aux.getDato().getEjecutivo().getNombre();
                    matriz[i][1] = aux.getDato().getUsuario().getName();
                    matriz[i][2] = aux.getDato().getServicio().getNombre();
                    matriz[i][3] = aux.getDato().getFechayHora();

                    i++;
                }
            } else if (CBsucursal.getSelectedItem().toString().equals("Todos") && !CBdia.getSelectedItem().toString().equals("Todos")) {
                if (aux.getDato().getFechayHora().contains(CBdia.getSelectedItem().toString())) {
                    matriz[i][0] = aux.getDato().getEjecutivo().getNombre();
                    matriz[i][1] = aux.getDato().getUsuario().getName();
                    matriz[i][2] = aux.getDato().getServicio().getNombre();
                    matriz[i][3] = aux.getDato().getFechayHora();

                    i++;
                }
            } else if (!CBsucursal.getSelectedItem().toString().equals("Todos") && !CBdia.getSelectedItem().toString().equals("Todos")) {
                if (aux.getDato().getFechayHora().contains(CBdia.getSelectedItem().toString()) && aux.getDato().getEjecutivo().getSucursal().equals(CBsucursal.getSelectedItem().toString())) {
                    matriz[i][0] = aux.getDato().getEjecutivo().getNombre();
                    matriz[i][1] = aux.getDato().getUsuario().getName();
                    matriz[i][2] = aux.getDato().getServicio().getNombre();
                    matriz[i][3] = aux.getDato().getFechayHora();

                    i++;
                }
            }
            aux = aux.getSiguiente();

        }
        q=i;
        ListaCircularSimple LCS = new ListaCircularSimple();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Ejecutivo.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            ListaCircularSimple vLCS = (ListaCircularSimple) input.readObject();
            input.close();
            miArchivo2.close();
            LCS = vLCS;
        } catch (Exception ex) {
            //System.out.println("Exception: " + ex.getMessage());

        }
        NodoLCS actual = LCS.getPrimero();
        double e = 0;
        if (LCS.esVacia()) {
            System.out.println("Lista vacia");
        } else {

            do {
                if (CBsucursal.getSelectedItem().toString().equals("Todos") && CBdia.getSelectedItem().toString().equals("Todos")) {
                    e++;
                } else if (!CBsucursal.getSelectedItem().toString().equals("Todos") && CBdia.getSelectedItem().toString().equals("Todos")) {
                    if (actual.getEjecutivo().getSucursal().equals(CBsucursal.getSelectedItem().toString())) {
                        e++;
                    }
                } else if (CBsucursal.getSelectedItem().toString().equals("Todos") && !CBdia.getSelectedItem().toString().equals("Todos")) {
                    e++;
                } else if (!CBsucursal.getSelectedItem().toString().equals("Todos") && !CBdia.getSelectedItem().toString().equals("Todos")) {
                    if (actual.getEjecutivo().getSucursal().equals(CBsucursal.getSelectedItem().toString())) {
                        e++;
                    }
                }

                actual = actual.getSiguiente();
            } while (actual != LCS.getPrimero());
        }

        Arbol a3 = new Arbol();
        Pila pila2 = new Pila();
        try {
            FileInputStream miArchivo2;
            miArchivo2 = new FileInputStream("Transferencia.su");
            ObjectInputStream input = new ObjectInputStream(miArchivo2);
            Arbol va3 = (Arbol) input.readObject();
            input.close();
            miArchivo2.close();
            a3 = va3;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        pila2 = a3.ArbolPila();
        nodoPila aux2 = pila2.getInicio();
        int j = 0;
        if (pila2.EsVacia()) {
            System.out.println("LA pila esta vacia");
        } else {

            while (aux2 != null) {
                 if (CBdia.getSelectedItem().toString().equals("Todos")) {
                  if (aux2.getSiguiente() != null) {
                    if (!aux2.getDato().getFechayHora().substring(0, 13).equals(aux2.getSiguiente().getDato().getFechayHora().substring(0, 13))) {
                        j++;
                    }
                } else {
                    if (aux2.getSiguiente() == null) {
                        j++;
                    }
                }
                }else{
                     j=1;
                 }
                
                
                
               
                aux2 = aux2.getSiguiente();
            }
        }
        txttotal.setText(i + "");
        if (e == 0) {
            txtejecutivo.setText(0 + "");
        } else {
            double p=q/e;
            txtejecutivo.setText(p + "");
        }
        if (j == 0) {
            txtdia.setText(0 + "");
        } else {
            double h=q/j;
            txtdia.setText(h+ "");
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Ejecutivo", "Usuario", "Servicio", "Fecha"
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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBdia;
    private javax.swing.JComboBox<String> CBsucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtdia;
    private javax.swing.JLabel txtejecutivo;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}