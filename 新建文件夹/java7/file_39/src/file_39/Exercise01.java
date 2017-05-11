package file_39;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class Exercise01 {
	public static void main(String[] args) {
			File file = null;
			JFileChooser fc = new JFileChooser(); // ����һ���ļ�ѡ����
			
			//���ļ������ѡ����ļ�����
			fc.setDialogTitle("open"); // ���ñ���
			if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {// ���ѡ����ȷ����ť���ͻ��ѡ����ļ�����
				file = fc.getSelectedFile();   //file���ѡȡ���ļ�����
			}
	
			String fileAbsoPath = file.getAbsolutePath(); // ���Եõ��ļ��ľ���·��
			System.out.println(fileAbsoPath); // ���·��
	
			// ��������������ȡ�ļ������ļ����ݽ��д���,Сдת��д
			byte by[]=new byte[1024];
			int b;
			//int j=0;
			String st="";
			try{
				FileInputStream in=new FileInputStream(file);
				while((b=in.read(by))!=-1){
					String s=new String(by);
					System.out.println(s);
					String Lower=s.toUpperCase();
					st=st+Lower;
				}
				in.close();
			}
			catch(IOException e){
				System.out.println("File read error"+e);
			}
			//System.out.println(st);
			byte [] byt=st.getBytes();
		//�������
		
		//�����ļ�
		fc.setDialogTitle("save");
		if (fc.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {// ���ѡ����ȷ����ť���ͻ��ѡ����ļ�����
			file = fc.getSelectedFile();   //file���ѡȡ���ļ�����
		}
		String fileAbsoPat= file.getAbsolutePath(); // ���Եõ��ļ��ľ���·��
		System.out.println(fileAbsoPat); // ���·��
		
		//�����������д�ļ�����
		try{
			FileOutputStream out = new FileOutputStream(file,true);
			out.write(byt);
			out.close();
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
	}
}
