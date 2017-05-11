import java.io.*;
import javax.swing.*;
import java.util.*;
public class Exercise01 {
	public static void main(String[] args) {
			File file = null;
			JFileChooser fc = new JFileChooser(); // 创建一个文件选择器
			
			//打开文件，获得选择的文件名称
			fc.setDialogTitle("open"); // 设置标题
			if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {// 如果选择了确定按钮，就获得选择的文件对象
				file = fc.getSelectedFile();   //file存放选取的文件对象
			}
	
			String fileAbsoPath = file.getAbsolutePath(); // 可以得到文件的绝对路径
			System.out.println(fileAbsoPath); // 输出路径
	
			// 创建输入流，读取文件，对文件内容进行处理,小写转大写
			byte by[]=new byte[10000];
			int b;
			//int j=0;
			String st="";
			try{
				FileInputStream in=new FileInputStream(file);
				while((b=in.read(by))!=-1){
					String s=new String(by);
					System.out.println(s);
					String Lower=s.toLowerCase();
					st=st+Lower;
				}
				in.close();
			}
			catch(IOException e){
				System.out.println("File read error"+e);
			}
			byte [] byt=st.getBytes();
		//处理完毕
		
		//保存文件
		fc.setDialogTitle("save");
		if (fc.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {// 如果选择了确定按钮，就获得选择的文件对象
			file = fc.getSelectedFile();   //file存放选取的文件对象
		}
		//创建输出流，写文件内容
		try{
			FileOutputStream out = new FileOutoutStream(file);
			out.write(byt);
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
	}
}
