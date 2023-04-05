package alquiler_bici_ampliado;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EmptyStackException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Clase principal, contiene todos los elementos funcionales del programa.
 * 
 * @author Laura Ferrer & Lucas González
 * @version 04/04/23
 */

public class Alquiler_bici_ampliado {

	private JFrame frmBikeRenting;
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
					window.frmBikeRenting.setVisible(true);
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
		frmBikeRenting = new JFrame();
		frmBikeRenting.setTitle("Bike & Renting by Double LL");
		frmBikeRenting.setResizable(false);
		frmBikeRenting.getContentPane().setBackground(new Color(51, 153, 204));
		frmBikeRenting.setBounds(100, 100, 1098, 743);
		frmBikeRenting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBikeRenting.getContentPane().setLayout(null);

		txtNombreAñadirUsuario = new JTextField();
		txtNombreAñadirUsuario.setColumns(10);
		txtNombreAñadirUsuario.setBounds(948, 346, 65, 24);
		frmBikeRenting.getContentPane().add(txtNombreAñadirUsuario);

		txtCdigoAñadirUsuario = new JTextField();
		txtCdigoAñadirUsuario.setColumns(10);
		txtCdigoAñadirUsuario.setBounds(948, 316, 65, 24);
		frmBikeRenting.getContentPane().add(txtCdigoAñadirUsuario);

		JLabel lblCodigoAñadirBici = new JLabel("Código bici:");
		lblCodigoAñadirBici.setForeground(new Color(0, 0, 0));
		lblCodigoAñadirBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoAñadirBici.setBounds(287, 323, 100, 38);
		frmBikeRenting.getContentPane().add(lblCodigoAñadirBici);

		txtCodigoAñadirBici = new JTextField();
		txtCodigoAñadirBici.setBounds(389, 331, 107, 24);
		frmBikeRenting.getContentPane().add(txtCodigoAñadirBici);
		txtCodigoAñadirBici.setColumns(10);

		JLabel lblCodigoDevolverBici = new JLabel("Código bici:");
		lblCodigoDevolverBici.setForeground(new Color(0, 0, 0));
		lblCodigoDevolverBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoDevolverBici.setBounds(287, 383, 100, 33);
		frmBikeRenting.getContentPane().add(lblCodigoDevolverBici);

		JLabel lblCodigoUsuarioDevolverBici = new JLabel("Código usuario:");
		lblCodigoUsuarioDevolverBici.setForeground(Color.BLACK);
		lblCodigoUsuarioDevolverBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoUsuarioDevolverBici.setBounds(287, 419, 141, 18);
		frmBikeRenting.getContentPane().add(lblCodigoUsuarioDevolverBici);

		JLabel lblCodigoAlquilarBici = new JLabel("Código usuario:");
		lblCodigoAlquilarBici.setForeground(new Color(0, 0, 0));
		lblCodigoAlquilarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoAlquilarBici.setBounds(287, 464, 141, 39);
		frmBikeRenting.getContentPane().add(lblCodigoAlquilarBici);

		JLabel lblCodigoUsuario = new JLabel("Código usuario:");
		lblCodigoUsuario.setForeground(new Color(0, 0, 0));
		lblCodigoUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoUsuario.setBounds(803, 319, 141, 21);
		frmBikeRenting.getContentPane().add(lblCodigoUsuario);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setForeground(new Color(0, 0, 0));
		lblNombreUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreUsuario.setBounds(803, 349, 141, 24);
		frmBikeRenting.getContentPane().add(lblNombreUsuario);

		DefaultTableModel modelUsuario = new DefaultTableModel();
		modelUsuario.addColumn("Código");
		modelUsuario.addColumn("Nombre");

		JTable tableUsuario = new JTable(modelUsuario);
		tableUsuario.setBounds(414, 166, -395, -100);
		tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		frmBikeRenting.getContentPane().add(tableUsuario);

		JScrollPane scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setBounds(586, 56, 427, 163);
		frmBikeRenting.getContentPane().add(scrollPaneUsuario);

		DefaultTableModel modelBici = new DefaultTableModel();
		modelBici.addColumn("Código");
		modelBici.addColumn("Alquiler");

		JTable tableBici = new JTable(modelBici);
		tableBici.setBounds(414, 166, -395, -100);
		tableBici.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		frmBikeRenting.getContentPane().add(tableBici);

		JScrollPane scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBounds(69, 58, 427, 163);
		frmBikeRenting.getContentPane().add(scrollPaneBici);

		JLabel lblBicis = new JLabel("Bicis");
		lblBicis.setForeground(new Color(0, 0, 0));
		lblBicis.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBicis.setBounds(232, 12, 93, 33);
		frmBikeRenting.getContentPane().add(lblBicis);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setForeground(new Color(0, 0, 0));
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 28));
		lblUsuarios.setBounds(736, 12, 156, 33);
		frmBikeRenting.getContentPane().add(lblUsuarios);

		JLabel lblCodigoUsuarioEliminar = new JLabel("Código usuario:");
		lblCodigoUsuarioEliminar.setForeground(Color.BLACK);
		lblCodigoUsuarioEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoUsuarioEliminar.setBounds(803, 409, 141, 26);
		frmBikeRenting.getContentPane().add(lblCodigoUsuarioEliminar);

		JLabel lblCodigoEliminarBici = new JLabel("Código bici:");
		lblCodigoEliminarBici.setForeground(Color.BLACK);
		lblCodigoEliminarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigoEliminarBici.setBounds(287, 540, 100, 37);
		frmBikeRenting.getContentPane().add(lblCodigoEliminarBici);

		JComboBox comboBoxCodigoAlquilarBici = new JComboBox();
		comboBoxCodigoAlquilarBici.setBounds(423, 390, 73, 18);
		frmBikeRenting.getContentPane().add(comboBoxCodigoAlquilarBici);

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
		comboBoxCodigoUsuarioAlquilarBici.setBounds(423, 419, 73, 18);
		frmBikeRenting.getContentPane().add(comboBoxCodigoUsuarioAlquilarBici);

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

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
		comboBoxDevolverBici.setBounds(423, 473, 73, 21);
		frmBikeRenting.getContentPane().add(comboBoxDevolverBici);

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

		JComboBox comboBoxEliminarUsuario = new JComboBox();
		comboBoxEliminarUsuario.setBounds(938, 413, 73, 18);
		frmBikeRenting.getContentPane().add(comboBoxEliminarUsuario);

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_usuario FROM usuario WHERE id_usuario <> 0");

			while (rs.next()) {
				comboBoxEliminarUsuario.addItem(rs.getInt("id_usuario"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

		JComboBox comboBoxEliminarBici = new JComboBox();
		comboBoxEliminarBici.setBounds(423, 549, 73, 18);
		frmBikeRenting.getContentPane().add(comboBoxEliminarBici);

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario <> 0");

			while (rs.next()) {
				comboBoxEliminarBici.addItem(rs.getInt("id_bici"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e3) {
			e3.printStackTrace();
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
		btnMostrarBici.setBounds(175, 230, 210, 60);
		frmBikeRenting.getContentPane().add(btnMostrarBici);

		btnMostrarBici.setMnemonic(KeyEvent.VK_B);

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
		btnMostrarUsuario.setBounds(698, 230, 210, 60);
		frmBikeRenting.getContentPane().add(btnMostrarUsuario);

		btnMostrarUsuario.setMnemonic(KeyEvent.VK_U);

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
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					txtCdigoAñadirUsuario.setText("");
					txtNombreAñadirUsuario.setText("");

					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT id_usuario FROM usuario WHERE id_usuario <> 0");

						while (rs.next()) {
							comboBoxEliminarUsuario.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}

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
		btnAñadirUsuario.setBounds(586, 313, 210, 60);
		frmBikeRenting.getContentPane().add(btnAñadirUsuario);

		btnAñadirUsuario.setMnemonic(KeyEvent.VK_A);

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
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					txtCodigoAñadirBici.setText("");

					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario <> 0");

						while (rs.next()) {
							comboBoxEliminarBici.addItem(rs.getInt("id_bici"));
						}

						rs.close();
						stmt.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}

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
		btnAñadirBici.setBounds(69, 315, 210, 60);
		frmBikeRenting.getContentPane().add(btnAñadirBici);

		btnAñadirBici.setMnemonic(KeyEvent.VK_D);

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
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

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
		btnAlquilarBici.setBounds(69, 383, 210, 60);
		frmBikeRenting.getContentPane().add(btnAlquilarBici);

		btnAlquilarBici.setMnemonic(KeyEvent.VK_Q);

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
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

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
		btnDevolverBici.setBounds(69, 455, 210, 60);
		frmBikeRenting.getContentPane().add(btnDevolverBici);

		btnDevolverBici.setMnemonic(KeyEvent.VK_D);

		JButton btnEliminarUsuario = new JButton(" Eliminar Usuario");
		btnEliminarUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/eliminarUsuario.png")));
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					PreparedStatement upd_pstmt = con.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

					upd_pstmt.setInt(1, (int) comboBoxEliminarUsuario.getSelectedItem());

					upd_pstmt.executeUpdate();

					try {
						ResultSet rs = stmt.executeQuery(
								"SELECT id_usuario FROM usuario WHERE id_usuario NOT IN (SELECT cod_usuario FROM bici) AND id_usuario <> 0");

						comboBoxCodigoUsuarioAlquilarBici.removeAllItems();

						while (rs.next()) {
							comboBoxCodigoUsuarioAlquilarBici.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}

					try {
						ResultSet rs = stmt.executeQuery("SELECT id_usuario FROM usuario WHERE id_usuario <> 0");

						comboBoxEliminarUsuario.removeAllItems();

						while (rs.next()) {
							comboBoxEliminarUsuario.addItem(rs.getInt("id_usuario"));
						}

						rs.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}

					btnMostrarUsuario.doClick();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Usuario eliminado corrctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se puede eliminar un usuario con una bici alquilada",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEliminarUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminarUsuario.setBackground(UIManager.getColor("Button.darkShadow"));
		btnEliminarUsuario.setBounds(586, 389, 210, 60);
		frmBikeRenting.getContentPane().add(btnEliminarUsuario);

		btnEliminarUsuario.setMnemonic(KeyEvent.VK_E);

		JButton btnEliminarBici = new JButton(" Eliminar Bici");
		btnEliminarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/eliminarBici.png")));
		btnEliminarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					PreparedStatement upd_pstmt = con.prepareStatement("DELETE FROM bici WHERE id_bici = ?");

					upd_pstmt.setInt(1, (int) comboBoxEliminarBici.getSelectedItem());

					upd_pstmt.executeUpdate();

					try {
						ResultSet rs = stmt.executeQuery("SELECT id_bici FROM bici WHERE cod_usuario <> 0");

						comboBoxEliminarUsuario.removeAllItems();

						while (rs.next()) {
							comboBoxEliminarUsuario.addItem(rs.getInt("id_bici"));
						}

						rs.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}

					try {
						ResultSet rs = stmt.executeQuery("SELECT cod_usuario FROM bici WHERE cod_usuario <> 0");

						comboBoxDevolverBici.removeAllItems();

						while (rs.next()) {
							comboBoxDevolverBici.addItem(rs.getInt("cod_usuario"));
						}

						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					btnMostrarBici.doClick();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Bici eliminada corrctamente ◕‿◕", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se puede eliminar una bici alquilada", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEliminarBici.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminarBici.setBackground(UIManager.getColor("Button.darkShadow"));
		btnEliminarBici.setBounds(69, 526, 210, 60);
		frmBikeRenting.getContentPane().add(btnEliminarBici);

		btnEliminarBici.setMnemonic(KeyEvent.VK_M);

		JButton buttonInfoAñadirBici = new JButton("");
		buttonInfoAñadirBici.setBorder(null);
		buttonInfoAñadirBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoAñadirBici.setBounds(23, 316, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoAñadirBici);
		buttonInfoAñadirBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 200);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite añadir una nueva bici a la base de datos.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código que tendrá la bici.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoAlquilarBici = new JButton("");
		buttonInfoAlquilarBici.setBorder(null);
		buttonInfoAlquilarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoAlquilarBici.setBounds(23, 387, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoAlquilarBici);
		buttonInfoAlquilarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite alquilar una nueva bici.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código de la bici y el del usuario que la ocupará.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoDevolverBici = new JButton("");
		buttonInfoDevolverBici.setBorder(null);
		buttonInfoDevolverBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoDevolverBici.setBounds(23, 455, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoDevolverBici);
		buttonInfoDevolverBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite devolver una bici.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código del usuario que la tiene alquilada.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoEliminarBici = new JButton("");
		buttonInfoEliminarBici.setBorder(null);
		buttonInfoEliminarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoEliminarBici.setBounds(23, 526, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoEliminarBici);
		buttonInfoEliminarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite eliminar una bici de la base de datos.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código de la bici.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoAñadirUsuario = new JButton("");
		buttonInfoAñadirUsuario.setBorder(null);
		buttonInfoAñadirUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoAñadirUsuario.setBounds(540, 316, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoAñadirUsuario);
		buttonInfoAñadirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite añadir un nuevo usuario a la base de datos.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código y el nombre que tendrá el usuario.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoEliminarUsuario = new JButton("");
		buttonInfoEliminarUsuario.setBorder(null);
		buttonInfoEliminarUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoEliminarUsuario.setBounds(540, 390, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoEliminarUsuario);
		buttonInfoEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón permite eliminar un usuario de la base de datos.<p> <br> <p style=\"text-align:center;\" >Es necesario indicar el código del usuario.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoMostrarUsuario = new JButton("");
		buttonInfoMostrarUsuario.setBorder(null);
		buttonInfoMostrarUsuario.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoMostrarUsuario.setBounds(652, 230, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoMostrarUsuario);
		buttonInfoMostrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón muestra todos los usuarios almacenados en la base de datos.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JButton buttonInfoMostrarBici = new JButton("");
		buttonInfoMostrarBici.setBorder(null);
		buttonInfoMostrarBici.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/info.png")));
		buttonInfoMostrarBici.setBounds(128, 233, 34, 33);
		frmBikeRenting.getContentPane().add(buttonInfoMostrarBici);
		buttonInfoMostrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog helpDialog = new JDialog();
				helpDialog.setTitle("Info");
				helpDialog.setSize(400, 300);
				JLabel helpLabel = new JLabel(
						"<html><body><p style=\"text-align:center;\">Este botón muestra todas las bicis almacenadas en la base de datos.<p><body><html>");
				helpDialog.getContentPane().add(helpLabel);
				helpDialog.setVisible(true);
				helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frmBikeRenting.setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu(" Opciones");
		mnOpciones.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/ajustes.png")));
		mnOpciones.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnOpciones);

		mnOpciones.setMnemonic(KeyEvent.VK_O);

		JMenuItem mntmTamaLetra = new JMenuItem("Tamaño letra");
		mntmTamaLetra.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/tamanoFuente.png")));
		mntmTamaLetra.setFont(new Font("Dialog", Font.BOLD, 16));
		mnOpciones.add(mntmTamaLetra);

		JSlider slider = new JSlider();
		mnOpciones.add(slider);

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int size = slider.getValue();
				Font font = new Font("Dialog", Font.PLAIN, size);
				lblCodigoAñadirBici.setFont(font);
				lblCodigoDevolverBici.setFont(font);
				lblCodigoUsuarioDevolverBici.setFont(font);
				lblCodigoAlquilarBici.setFont(font);
				lblCodigoEliminarBici.setFont(font);
				lblCodigoUsuario.setFont(font);
				lblNombreUsuario.setFont(font);
				lblCodigoUsuarioEliminar.setFont(font);
				btnMostrarUsuario.setFont(font);
				btnAñadirUsuario.setFont(font);
				btnEliminarUsuario.setFont(font);
				btnMostrarBici.setFont(font);
				btnAlquilarBici.setFont(font);
				btnDevolverBici.setFont(font);
				btnEliminarBici.setFont(font);
				btnAñadirBici.setFont(font);
			}
		});

		JMenu mnFondo = new JMenu("Fondo");
		mnOpciones.add(mnFondo);
		mnFondo.setForeground(Color.BLACK);
		mnFondo.setFont(new Font("Dialog", Font.BOLD, 16));
		mnFondo.setBackground(new Color(51, 51, 204));

		mnFondo.setMnemonic(KeyEvent.VK_F);

		JMenuItem mntmDefault = new JMenuItem("Default\r\n");
		mntmDefault.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmDefault.setForeground(new Color(51, 153, 204));
		mntmDefault.setBackground(new Color(51, 153, 204));
		mntmDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBikeRenting.getContentPane().setBackground(new Color(51, 153, 204));
			}
		});
		mnFondo.add(mntmDefault);
		mntmDefault.setMnemonic(KeyEvent.VK_D);

		JMenuItem mntmSalmon = new JMenuItem("Salmón");
		mntmSalmon.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmSalmon.setForeground(new Color(250, 128, 114));
		mntmSalmon.setBackground(new Color(250, 128, 114));
		mntmSalmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBikeRenting.getContentPane().setBackground(new Color(250, 128, 114));
			}
		});
		mnFondo.add(mntmSalmon);
		mntmSalmon.setMnemonic(KeyEvent.VK_S);

		JMenuItem mntmVerde = new JMenuItem("Verde");
		mntmVerde.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmVerde.setForeground(new Color(85, 107, 47));
		mntmVerde.setBackground(new Color(85, 107, 47));
		mntmVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBikeRenting.getContentPane().setBackground(new Color(85, 107, 47));
			}
		});
		mnFondo.add(mntmVerde);
		mntmVerde.setMnemonic(KeyEvent.VK_V);

		JMenuItem mntmOcre = new JMenuItem("Ocre");
		mntmOcre.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmOcre.setForeground(new Color(255, 222, 173));
		mntmOcre.setBackground(new Color(255, 222, 173));
		mntmOcre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBikeRenting.getContentPane().setBackground(new Color(255, 222, 173));
			}
		});
		mnFondo.add(mntmOcre);
		mntmOcre.setMnemonic(KeyEvent.VK_O);

		JMenuItem mntmSalir = new JMenuItem(" Salir");
		mntmSalir.setIcon(new ImageIcon(Alquiler_bici_ampliado.class.getResource("/img/salir.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setForeground(new Color(255, 0, 0));
		mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
		mnOpciones.add(mntmSalir);

		mntmSalir.setMnemonic(KeyEvent.VK_S);

	}
}