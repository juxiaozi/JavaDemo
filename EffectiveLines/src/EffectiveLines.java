import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by ju on 2016/6/16.
 * �ж�java�ļ�����Ч����
 */
public class EffectiveLines {
    //ͳ����Ч��������
    private int lineCount=0;

    //�ж��ļ��Ƿ���java�ļ�
    private  boolean isJavaFile(File file){
        if(file.getName().endsWith(".java")){
            return true;
        }
        return false;
    }

    //ͳ���ļ�����Ч����
    public int effectiveLines(File file){
        if(isJavaFile(file)){
            try {
                BufferedReader br=new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null){
                    line=line.trim();
                    if(!(("".equals(line))||line.startsWith("//")||
                            (line.startsWith("/*")&&(line.endsWith("*/"))))){
                        lineCount++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lineCount;
    }
    public static void main(String [] args){
        //��Test.javaΪ�����м򵥲���
        File file=new File("H:\\Test.java");
        EffectiveLines lines=new EffectiveLines();
        int count=lines.effectiveLines(file);
        System.out.println(count);
    }
}
