/* crear una interface de usuario sin layouts que permita efecuar el cambio de moneda:
 * Entrada: Bolivianos
 * Salida: Dolares y Euros 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ejemplo extends JFrame implements ActionListener {
	JButton bt1,bt2,bt3;
	JLabel lb1,lb2;
	JTextField tf1,tf2,tf3;
	public Ejemplo () {
		super("Cambio de moneda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		lb1 = new JLabel("Ingrese el monto: ");
		lb1.setBounds(15,5,200,20);// (x,y,ancho,alto)
		tf1 = new JTextField (10);
		tf1.setBounds(120,5,200,20);
		lb2 = new JLabel("El cambio es:");
		lb2.setBounds(15,25,200,20);
		tf2 = new JTextField (10);
		tf2.setBounds(120,25,100,20);
		tf3 = new JTextField (10);
		tf3.setBounds(235,25,100,20);
		bt1 = new JButton ("Calcular");
		bt1.setBounds(15,50,100,20);
		bt2 = new JButton("Borrar");
		bt2.setBounds(130,50,100,20);
		bt3 = new JButton("Finalizar");
		bt3.setBounds(245,50,100,20);
		add(lb1);		add(tf1);		add(lb2);		add(tf2);	add(tf3);
		add(bt1);	add(bt2);  add(bt3);
		bt1.addActionListener(this);
		bt1.setToolTipText("Calcular el cambio");
		bt2.addActionListener(this);
		bt2.setToolTipText("Limpiar resultado");
		bt3.addActionListener(this);
		bt3.setToolTipText("");
		tf2.setEditable(false);
		tf3.setEditable(false);
		setVisible(true);
	}
	public void actionPerformed (ActionEvent event) {
		if(event.getSource()==bt1){
			double x=Double.parseDouble(tf1.getText());
			String cam1=cambio1(x);
			String cam2=cambio2(x);
			tf2.setText(cam1);
			tf3.setText(cam2);
		}
		if(event.getSource()==bt2){
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		}
		if(event.getSource()==bt3){
			System.exit(0);
		}
	}
	public String cambio1(double bol) {
		double eu=bol*9.92;
		return "Euros: "+eu;
	}
	public String cambio2(double bol) {
		double eu=bol*9.92;
		return "Dolares: "+eu;
	}
}