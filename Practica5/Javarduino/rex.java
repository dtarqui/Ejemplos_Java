package Javarduino;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class rex {
	public static void main(String[] args) {
				try {
					ino.arduinoRX("COM5", 9600, listener);
	        } catch (ArduinoException ex) {
	            Logger.getLogger(rex.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SerialPortException ex) {
	            Logger.getLogger(rex.class.getName()).log(Level.SEVERE, null, ex);
	        }
    }
	static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	static SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (ino.isMessageAvailable()) {
					String msg = ino.printMessage();
					try {
						adicionar("Personal.bin",msg);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(rex.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(rex.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	};
	public static void adicionar(String string, String msg) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			String nom,ocu;
			int edad;	
			nom=JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
			ocu=JOptionPane.showInputDialog(null,"Ocupacion: ");
			edad= Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
			fs.writeUTF(msg);
			fs.writeUTF(nom);
			fs.writeInt(edad);
			fs.writeUTF(ocu);
			fs.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
}