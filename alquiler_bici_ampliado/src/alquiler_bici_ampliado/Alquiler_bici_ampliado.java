package alquiler_bici_ampliado;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EmptyStackException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * Clase principal, contiene todos los elementos funcionales del programa.
 * 
 * @author Laura Ferrer & Lucas González
 * @version 04/04/23
 */

public class Alquiler_bici_ampliado {

	private JFrame frame;
	private JTextField txtCodigoAñadirBici;
	private JTextField txtNombreAñadirUsuario;
	private JTextField txtCdigoAñadirUsuario;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alquiler_bici_ampliado window = new Alquiler_bici_ampliado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public Alquiler_bici_ampliado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.setBounds(100, 100, 928, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtNombreAñadirUsuario = new JTextField();
		txtNombreAñadirUsuario.setColumns(10);
		txtNombreAñadirUsuario.setBounds(827, 347, 75, 24);
		frame.getContentPane().add(txtNombreAñadirUsuario);

		txtCdigoAñadirUsuario = new JTextField();
		txtCdigoAñadirUsuario.setColumns(10);
		txtCdigoAñadirUsuario.setBounds(827, 317, 75, 24);
		frame.getContentPane().add(txtCdigoAñadirUsuario);

		JLabel lblCodigoAñadirBici = new JLabel("Código bici:");
		lblCodigoAñadirBici.setForeground(new Color(0, 0, 0));
		lblCodigoAñadirBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoAñadirBici.setBounds(230, 333, 100, 15);
		frame.getContentPane().add(lblCodigoAñadirBici);

		txtCodigoAñadirBici = new JTextField();
		txtCodigoAñadirBici.setBounds(332, 330, 107, 24);
		frame.getContentPane().add(txtCodigoAñadirBici);
		txtCodigoAñadirBici.setColumns(10);

		JLabel lblCodigoDevolverBici = new JLabel("Código bici:");
		lblCodigoDevolverBici.setForeground(new Color(0, 0, 0));
		lblCodigoDevolverBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoDevolverBici.setBounds(230, 392, 100, 15);
		frame.getContentPane().add(lblCodigoDevolverBici);

		JLabel lblCodigoUsuarioDevolverBici = new JLabel("Código usuario:");
		lblCodigoUsuarioDevolverBici.setForeground(Color.BLACK);
		lblCodigoUsuarioDevolverBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoUsuarioDevolverBici.setBounds(230, 418, 141, 15);
		frame.getContentPane().add(lblCodigoUsuarioDevolverBici);

		JLabel lblCodigoAlquilarBici = new JLabel("Código usuario:");
		lblCodigoAlquilarBici.setForeground(new Color(0, 0, 0));
		lblCodigoAlquilarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoAlquilarBici.setBounds(230, 475, 141, 15);
		frame.getContentPane().add(lblCodigoAlquilarBici);

		JLabel lblCodigoUsuario = new JLabel("Código usuario:");
		lblCodigoUsuario.setForeground(new Color(0, 0, 0));
		lblCodigoUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoUsuario.setBounds(692, 320, 141, 15);
		frame.getContentPane().add(lblCodigoUsuario);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setForeground(new Color(0, 0, 0));
		lblNombreUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreUsuario.setBounds(692, 350, 141, 15);
		frame.getContentPane().add(lblNombreUsuario);

		DefaultTableModel modelUsuario = new DefaultTableModel();
		modelUsuario.addColumn("Código");
		modelUsuario.addColumn("Nombre");

		JTable tableUsuario = new JTable(modelUsuario);
		tableUsuario.setBounds(414, 166, -395, -100);
		tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		frame.getContentPane().add(tableUsuario);

		JScrollPane scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setBounds(475, 57, 427, 163);
		frame.getContentPane().add(scrollPaneUsuario);

		DefaultTableModel modelBici = new DefaultTableModel();
		modelBici.addColumn("Código");
		modelBici.addColumn("Alquiler");

		JTable tableBici = new JTable(modelBici);
		tableBici.setBounds(414, 166, -395, -100);
		tableBici.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		frame.getContentPane().add(tableBici);

		JScrollPane scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBounds(12, 57, 427, 163);
		frame.getContentPane().add(scrollPaneBici);

		JLabel lblBicis = new JLabel("Bicis");
		lblBicis.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBicis.setBounds(188, 11, 93, 33);
		frame.getContentPane().add(lblBicis);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 28));
		lblUsuarios.setBounds(641, 13, 156, 33);
		frame.getContentPane().add(lblUsuarios);

		JComboBox comboBoxCodigoAlquilarBici = new JComboBox();
		comboBoxCodigoAlquilarBici.setBounds(366, 389, 73, 18);
		frame.getContentPane().add(comboBoxCodigoAlquilarBici);

		/**
		 * Rellenamos el comboBox con los id de las bicis ya creadas.
		 */

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario = 0 ORDER BY id_bici");

			while (rs.next()) {
				comboBoxCodigoAlquilarBici.addItem(rs.getInt("id_bici"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Rellenamos el comboBox con los id de los usuarios ya creados.
		 */

		JComboBox comboBoxCodigoUsuarioAlquilarBici = new JComboBox();
		comboBoxCodigoUsuarioAlquilarBici.setBounds(366, 418, 73, 18);
		frame.getContentPane().add(comboBoxCodigoUsuarioAlquilarBici);

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici)");

			comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

			while (rs.next()) {
				comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JComboBox comboBoxDevolverBici = new JComboBox();
		comboBoxDevolverBici.setBounds(366, 472, 73, 21);
		frame.getContentPane().add(comboBoxDevolverBici);

		/**
		 * Rellenamos el comboBox con los id de las bicis ya creadas.
		 */

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cod_usuario FROM bici WHERE cod_usuario <> 0");

			while (rs.next()) {
				comboBoxDevolverBici.addItem(rs.getInt("cod_usuario"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Este botón permite mostrar las bicis, que se encuentran en la base de datos
		 * almacenados, en una tabla ordenadamente.
		 */

		JButton btnMostrarBici = new JButton("Mostrar Bicis");
		btnMostrarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		btnMostrarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/MostrarBici.png")));
		btnMostrarBici.setBackground(UIManager.getColor("Button.darkShadow"));
		btnMostrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelBici.setRowCount(0);

					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici ORDER BY id_bici");

					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("id_bici");
						int estado = rs.getInt("cod_usuario");
						if (estado == 0) {
							row[1] = "Libre";
						} else {
							row[1] = "Ocupado";
						}
						modelBici.addRow(row);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnMostrarBici.setBounds(118, 229, 210, 60);
		frame.getContentPane().add(btnMostrarBici);

		btnMostrarBici.doClick();

		/**
		 * Este botón permite mostrar los usuarios, que se encuentran en la base de
		 * datos almacenados, en una tabla ordenadamente.
		 */

		JButton btnMostrarUsuario = new JButton("Mostrar Usuarios");
		btnMostrarUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		btnMostrarUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/MostrarUsuario.png")));
		btnMostrarUsuario.setBackground(UIManager.getColor("Button.background"));
		btnMostrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelUsuario.setRowCount(0);

					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE id_usuario != 0");

					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("id_usuario");
						row[1] = rs.getString("nombre");
						modelUsuario.addRow(row);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "No se pueden mostrar los usuarios", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMostrarUsuario.setBounds(587, 231, 210, 60);
		frame.getContentPane().add(btnMostrarUsuario);

		btnMostrarUsuario.doClick();

		/**
		 * Este botón permite añadir un nuevo usuario a la base de datos
		 */

		JButton btnAñadirUsuario = new JButton(" Añadir Usuario");
		btnAñadirUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAñadirUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/AñadirUsuario.png")));
		btnAñadirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_AnadirUsuario = con
							.prepareStatement("INSERT INTO usuario (id_usuario, nombre) VALUES (?, ?)");

					String codUsuario = txtCdigoAñadirUsuario.getText();
					int newCodUsuario = Integer.parseInt(codUsuario);

					String newNombreUsuario = txtNombreAñadirUsuario.getText();

					ins_AnadirUsuario.setInt(1, newCodUsuario);
					ins_AnadirUsuario.setString(2, newNombreUsuario);

					ins_AnadirUsuario.executeUpdate();
					ins_AnadirUsuario.close();

					btnMostrarUsuario.doClick();

					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici)");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					txtCdigoAñadirUsuario.setText("");
					txtNombreAñadirUsuario.setText("");

					JOptionPane.showMessageDialog(null, "Usuario añadido correctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "No se puede añadir el usuario, 'Código' repetido!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAñadirUsuario.setBackground(UIManager.getColor("Button.background"));
		btnAñadirUsuario.setBounds(475, 314, 210, 60);
		frame.getContentPane().add(btnAñadirUsuario);

		/**
		 * Este botón permite añadir una nueva bici a la base de datos.
		 */

		JButton btnAñadirBici = new JButton("  Añadir Bici");
		btnAñadirBici.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAñadirBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/AñadirBici.png")));
		btnAñadirBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_AnadirBici = con
							.prepareStatement("INSERT INTO bici (id_bici, cod_usuario) VALUES (?, 0)");

					String codBici = txtCodigoAñadirBici.getText();
					int newCodBici = Integer.parseInt(codBici);

					ins_AnadirBici.setInt(1, newCodBici);

					ins_AnadirBici.executeUpdate();
					ins_AnadirBici.close();

					btnMostrarBici.doClick();

					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt
								.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario = 0 ORDER BY id_bici");

						comboBoxCodigoAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoAlquilarBici.addItem(rs.getInt("id_bici"));
						}

						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici)");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					txtCodigoAñadirBici.setText("");

					JOptionPane.showMessageDialog(null, "Bici añadida correctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "No se puede añadir la bici, 'Código' repetido!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAñadirBici.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		btnAñadirBici.setBounds(12, 314, 210, 60);
		frame.getContentPane().add(btnAñadirBici);

		/**
		 * Este botón permite alquilar una bici, asociar el código de una bici con el de
		 * un usuario.
		 */

		JButton btnAlquilarBici = new JButton(" Alquilar Bici");
		btnAlquilarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAlquilarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/AlquilarBici.png")));
		btnAlquilarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					PreparedStatement upd_pstmt = con
							.prepareStatement("UPDATE bici SET cod_usuario = ? WHERE id_bici = ?");

					upd_pstmt.setInt(1, (int) comboBoxCodigoUsuarioAlquilarBici.getSelectedItem());
					upd_pstmt.setInt(2, (int) comboBoxCodigoAlquilarBici.getSelectedItem());

					upd_pstmt.executeUpdate();

					try {
						ResultSet rs = stmt
								.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario = 0 ORDER BY id_bici");

						comboBoxCodigoAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoAlquilarBici.addItem(rs.getInt("id_bici"));
						}

						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					try {
						ResultSet rs = stmt.executeQuery(
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici)");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					try {
						ResultSet rs = stmt.executeQuery("SELECT cod_usuario FROM bici WHERE cod_usuario <> 0");

						comboBoxDevolverBici.removeAllItems();

						while (rs.next()) {
							comboBoxDevolverBici.addItem(rs.getInt("cod_usuario"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					btnMostrarBici.doClick();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Bici alquilada correctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "No se puede alquilar la bici", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAlquilarBici.setBackground(UIManager.getColor("Button.background"));
		btnAlquilarBici.setBounds(12, 382, 210, 60);
		frame.getContentPane().add(btnAlquilarBici);

		/**
		 * Este botón permite devolver una bici, desasociar el código del usuario a la
		 * bici para que esta vuelva a estar libre.
		 */

		JButton btnDevolverBici = new JButton(" Devolver Bici");
		btnDevolverBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					PreparedStatement upd_pstmt = con
							.prepareStatement("UPDATE bici SET cod_usuario = 0 WHERE cod_usuario = ?");

					upd_pstmt.setInt(1, (int) comboBoxDevolverBici.getSelectedItem());

					upd_pstmt.executeUpdate();

					try {
						ResultSet rs = stmt.executeQuery(
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici)");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					try {
						ResultSet rs = stmt
								.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario = 0 ORDER BY id_bici");

						comboBoxCodigoAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoAlquilarBici.addItem(rs.getInt("id_bici"));
						}

						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {
						ResultSet rs = stmt.executeQuery("SELECT cod_usuario FROM bici WHERE cod_usuario <> 0");

						comboBoxDevolverBici.removeAllItems();

						while (rs.next()) {
							comboBoxDevolverBici.addItem(rs.getInt("cod_usuario"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}

					btnMostrarBici.doClick();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Bici devuelta correctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnDevolverBici.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDevolverBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/DevolverBici.png")));
		btnDevolverBici.setBackground(UIManager.getColor("Button.darkShadow"));
		btnDevolverBici.setBounds(12, 454, 210, 60);
		frame.getContentPane().add(btnDevolverBici);
	}
}