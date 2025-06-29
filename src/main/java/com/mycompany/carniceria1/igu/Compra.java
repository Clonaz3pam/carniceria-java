
package com.mycompany.carniceria1.igu;

import com.mycompany.carniceria1.logica.Controladora;
import com.mycompany.carniceria1.logica.DetalleCompra;
import com.mycompany.carniceria1.logica.Producto;
import com.mycompany.carniceria1.logica.SesionUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Compra extends javax.swing.JFrame {
Controladora control;
List <Producto> listaProductos;
Double totalCarrito=0.0;
    public Compra() {
        initComponents();
        control = new Controladora();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMiCarrito = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnCancelarCompra = new javax.swing.JButton();
        btnFinalizarCompra = new javax.swing.JButton();
        txtCantidadAPedir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Mi carrito:");

        tablaMiCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaMiCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMiCarrito);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("¿Cómo desea el corte?");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane3.setViewportView(txtObservacion);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad a pedir(en KG): ");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setText("Seleccion de productos");

        tablaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaProductos);

        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAgregarProducto.setText("Agregar al carrito");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnCancelarCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCancelarCompra.setText("Cancelar compra");
        btnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompraActionPerformed(evt);
            }
        });

        btnFinalizarCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnFinalizarCompra.setText("Finalizar compra");
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        txtCantidadAPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadAPedirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Total:");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidadAPedir))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal)))
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidadAPedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(btnAgregarProducto)
                        .addGap(16, 16, 16)))
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizarCompra)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompraActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarCompraActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablaCliente();
        
        //Hago tabla de MI CARRITO
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }
        };
        String [] titulos = {"Nombre Corte", "Precio KG", "Cantidad KG", "Subtotal", "Observación"};
        modeloTabla.setColumnIdentifiers(titulos);
        tablaMiCarrito.setModel(modeloTabla);
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
    //Verifico que haya una fila seleccionada en la tabla de productos.
    int filaSeleccionada = tablaProductos.getSelectedRow();
    if (filaSeleccionada == -1){
        mostrarMensaje("Debe seleccioar un producto de la tabla", "error", "Error al agregar");
        return;
    }
    //Obtendo los datos del producto seleccionado
    Producto productoSeleccionado = listaProductos.get(filaSeleccionada);
    
    String nombre = productoSeleccionado.getNombre();
    double precio = productoSeleccionado.getPrecio();
    double cantidad;
    try {
      cantidad = Double.parseDouble(txtCantidadAPedir.getText());
      if (cantidad<=0) {
          mostrarMensaje("Por favor, ingrese una cantidad mayor a cero", "error", "Cantidad ínvalida");
          return;
      }
    } catch (NumberFormatException e ) {
        mostrarMensaje("Debe ingresar un número válido para la cantidad","error", "Error de formato");
        return;
    }
            
    String observacion = productoSeleccionado.getObservacion();
    //calculo de subtotal
    double subtotal = cantidad * precio;
    //Ahora agrego estos datos a la tabla del carrito
    DefaultTableModel modeloCarrito = (DefaultTableModel) tablaMiCarrito.getModel();
    Object [] fila = {nombre, precio, cantidad, subtotal, observacion};
    modeloCarrito.addRow(fila);
    
    //Limpio los campos que usa el cliente
    txtObservacion.setText("");
    txtDescripcion.setText("");
    totalCarrito += subtotal;
    txtTotal.setText(String.format("%.2f", totalCarrito));
    
    
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        txtTotal.setEditable(false);
        
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtCantidadAPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadAPedirActionPerformed
        txtCantidadAPedir.setToolTipText("Ingrese la cantidad en kilogramos. Pj: 1.5");
    }//GEN-LAST:event_txtCantidadAPedirActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int filaseleccionada = tablaMiCarrito.getSelectedRow();
        if (filaseleccionada == -1){
            mostrarMensaje("Debe seleccionar un producto del carrito", "error", "Error al eliminar");
            return;            
        }
        DefaultTableModel modeloCarrito = (DefaultTableModel) tablaMiCarrito.getModel();
        //Resto el subtotal del TOTAL para quitar el precio del producto eliminado
        //traigo el SUBTOTOTAL del producto a eliminar
        double subtotal = (double)tablaMiCarrito.getValueAt(filaseleccionada, 3);
        //Resto ese subtotal al total 
        totalCarrito -= subtotal;
        //borro la fila seleccionada
        modeloCarrito.removeRow(filaseleccionada);
        txtTotal.setText(String.valueOf(totalCarrito));
        
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMiCarrito.getModel();
        int filas = modelo.getRowCount();
        if (filas == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos en el carrito");
            return;
        }
        //Creo la compra
        com.mycompany.carniceria1.logica.Compra compra = new com.mycompany.carniceria1.logica.Compra ();
        compra.setFecha(new Date());
        compra.setHora(LocalTime.now());
        compra.setUsuario(SesionUsuario.usuarioActual);
        
        List <DetalleCompra> listaDetalles = new ArrayList<>();
        
        //armar los detalles desde cada fila de la tabla
        for (int i = 0; i < filas; i++) {
            DetalleCompra detalle = new DetalleCompra();

           String nombreProducto = (String) modelo.getValueAt(i, 0);
        double precioUnitario = (double) modelo.getValueAt(i, 1);
        double cantidad = (double) modelo.getValueAt(i, 2);
        double subtotal = (double) modelo.getValueAt(i, 3);
            
            // Buscar el producto real por nombre
            Producto producto = control.buscarProductoPorNombre(nombreProducto);
            detalle.setProducto(producto);
            if (producto == null || producto.getId() <= 0) {
                mostrarMensaje("El producto no se encontró correctamente en la base de datos.", "error", "Error al finalizar");
                return;
            }
            detalle.setCantidad(cantidad);
            detalle.setSubtotal(subtotal);
            detalle.setFecha(new Date());
            detalle.setHora(LocalTime.now());
            detalle.setCompra(compra);
            
            listaDetalles.add(detalle);  
        }
        compra.setListaDetalles(listaDetalles);
        //guardo en la BD
        control.guardarCompra(compra);
        //MENSAJE
       mostrarMensaje("¡Compra finalizada correctamente!", "info", "Éxito");

        modelo.setRowCount(0); // Vacía la tabla
 // Limpiar tabla y campos
        modelo.setRowCount(0);
        txtTotal.setText("");
        txtDescripcion.setText("");
        txtCantidadAPedir.setText("");
        txtObservacion.setText("");

        
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed
public void mostrarMensaje (String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCancelarCompra;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaMiCarrito;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantidadAPedir;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCliente() {
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;        
            }            
        }; 
        String titulos [] = {"Nombre corte", "Precio KG", "Stock en KG"};
        modeloTabla.setColumnIdentifiers(titulos);
        listaProductos = control.traerProductos();
        if (listaProductos != null) {
            for (Producto produ : listaProductos) {
                Object [] objeto = {produ.getNombre(), produ.getPrecio(), produ.getStock()};
                modeloTabla.addRow(objeto);
            }
        }
        tablaProductos.setModel(modeloTabla);
        
        //AHORA AGREGO EL MOUSELISTENER
        tablaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaProductos.rowAtPoint(e.getPoint());
                if (filaSeleccionada != -1) {
                    Producto produSeleccionado = listaProductos.get(filaSeleccionada);
                    txtDescripcion.setText(produSeleccionado.getDescripcion());
                }
            }
            
        }
        );
    }
}
