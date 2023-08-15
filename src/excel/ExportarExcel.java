package excel;

import java.io.*;
import javax.swing.*;
import jxl.write.*;
import jxl.*;
/**
 *
 * @author RUBEN
 */
public class ExportarExcel {
private File file;// archivo que manejaremos
private JTable table; //la tabla que recibira
private String nombreTab; //nombre del archivo
//constructor ( inicializa las variables)
public ExportarExcel(JTable table,File file,String nombreTab){
this.file=file;
this.table=table;
this.nombreTab=nombreTab;
}
//metodo para exportar
public boolean export(){
try{
System.out.print("Iniciando processo de exportar"); 
//hacemos referencia al archivo deseado
DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
//Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
WritableWorkbook w = Workbook.createWorkbook(out);

//Coloca el nombre del "tab"(el nombre del arcchivo en el archivo y tambien en la hoja de excel)
WritableSheet s = w.createSheet(nombreTab, 0);
//ocupamos dos ciclos para recorrer nuestra tabla y escribir en las celdas de excel

for(int i=0;i< table.getRowCount();i++){
 for(int j=0;j<table.getColumnCount();j++){
  Object objeto=table.getValueAt(i,j);
   s.addCell(new Label(j, i, String.valueOf(objeto)));
}
}
//escribimos en el archivo
w.write();
 
w.close();
out.close();
JOptionPane.showMessageDialog(null,"Exportação realizada com sucesso,veja na pasta padrão...");
return true;
}catch(IOException ex){ex.printStackTrace();}
catch(WriteException ex){ex.printStackTrace();}
  JOptionPane.showMessageDialog(null, "Erro na exportação do arquivo");
return false;
}
}



   