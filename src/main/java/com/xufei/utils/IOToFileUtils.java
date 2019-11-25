package com.xufei.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Java读取文件工具类——IO
 * <请替换成功能描述> <br>
 * <请替换成详细描述>
 * @author caizh
 * @since [1.0.0]
 * @version [1.0.0,2017年2月6日]
 */
public class IOToFileUtils {

    /**
     * 以字节为单位读取文件，常用于读取二进制文件，如：图片、声音、影像等
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        try{
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            //一次读取一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while((tempbyte=in.read())!= -1){
                System.out.write(tempbyte);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.println("以字节为单位读取文件内容，一次读取多个字节：");
            //一次读取多个字节
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            //读入多个字节到字节数组中，byteread为一次读入的字节数
            while((byteread=in.read(tempbytes))!= -1){
                System.out.write(tempbytes, 0, byteread);;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件，常用于读取文本，数字等类型的文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        try{
            System.out.println("以字符为单位读取文件内容，一次读取一个字符：");
            //一次读取一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while((tempchar=reader.read())!= -1){
                //对于window下，/r/n这两个字符在一起时，表示一个换行。
                //但如果这两个字符分开显示是，会换两次行。
                //因此，屏蔽掉/r,或者屏蔽/n。否则，将会多出很多空行
                if(((char)tempchar)!= '\r'){
                    System.out.print((char)tempchar);
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();  
        }
        try{
            System.out.println("以字符为单位读取文件内容，一次读取多个字符：");
            //一次读取多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            //读取多个字符到字符数组中，charread为一次读取字符数
            while((charread=reader.read(tempchars))!=-1){
                //屏蔽掉/r不显示
                if((charread == tempchars.length) && (tempchars[tempchars.length-1]!='\r')){
                    System.out.print(tempchars);
                }else{
                    for(int i=0;i<charread;i++){
                        if(tempchars[i] == '\r'){
                            continue;
                        }else{
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static List<String> readFileByCharsList(String fileName){
    	File file = new File(fileName);
    	Reader reader = null;
    	 List<String> strList = new ArrayList<>();
    	try{
    		System.out.println("以字符为单位读取文件内容，一次读取一个字符：");
    		//一次读取一个字符
    		reader = new InputStreamReader(new FileInputStream(file));
    		int tempchar;
    		while((tempchar=reader.read())!= -1){
    			//对于window下，/r/n这两个字符在一起时，表示一个换行。
    			//但如果这两个字符分开显示是，会换两次行。
    			//因此，屏蔽掉/r,或者屏蔽/n。否则，将会多出很多空行
    			if(((char)tempchar)!= '\r'){
    				//System.out.print((char)tempchar);
    				strList.add(tempchar+"");
    			}
    		}
    		reader.close();
    	}catch(Exception e){
    		e.printStackTrace();  
    	}
    	try{
    		System.out.println("以字符为单位读取文件内容，一次读取多个字符：");
    		//一次读取多个字符
    		char[] tempchars = new char[30];
    		int charread = 0;
    		reader = new InputStreamReader(new FileInputStream(fileName));
    		//读取多个字符到字符数组中，charread为一次读取字符数
    		while((charread=reader.read(tempchars))!=-1){
    			//屏蔽掉/r不显示
    			if((charread == tempchars.length) && (tempchars[tempchars.length-1]!='\r')){
    				//System.out.print(tempchars);
    				strList.add(tempchars+"");
    			}else{
    				for(int i=0;i<charread;i++){
    					if(tempchars[i] == '\r'){
    						continue;
    					}else{
    						//System.out.print(tempchars[i]);
    						strList.add(tempchars[i]+"");
    					}
    				}
    			}
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(reader != null){
    			try {
    				reader.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	
    	return strList;
    }

    /**
     * 以行为单位读取文件，常用于读取面向行的格式化文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("以行为单位读取文件内容，一次读取一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //一次读入一行，直到读入null为文件结束
            while((tempString = reader.readLine())!=null){
                //显示行号
                System.out.println("line "+line+":"+tempString);
                line++;
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static List<String> readFileByLinesListFiles(File file){
    	//File file = new File(fileName);
    	BufferedReader reader = null;
    	List<String> strList = new ArrayList<>();
    	try{
    		System.out.println("以行为单位读取文件内容，一次读取一整行：");
    		reader = new BufferedReader(new FileReader(file));
    		String tempString = null;
    		//int line = 1;
    		//一次读入一行，直到读入null为文件结束
    		while((tempString = reader.readLine())!=null){
    			//显示行号
    			//System.out.println("line "+line+":"+tempString);
    			strList.add(tempString);
    			//line++;
    		}
    		reader.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return strList;
    }
    public static List<String> readFileByLinesList(String fileName){
    	File file = new File(fileName);
    	BufferedReader reader = null;
    	List<String> strList = new ArrayList<>();
    	try{
    		System.out.println("以行为单位读取文件内容，一次读取一整行：");
    		reader = new BufferedReader(new FileReader(file));
    		String tempString = null;
    		//int line = 1;
    		//一次读入一行，直到读入null为文件结束
    		while((tempString = reader.readLine())!=null){
    			//显示行号
    			//System.out.println("line "+line+":"+tempString);
    			strList.add(tempString);
    			//line++;
    		}
    		reader.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return strList;
    }
    
    //一次读取整个文件
    public String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }

    /**
     * 随机读取文件内容
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("随机读取一段文件内容：");
            //打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName,"r");
            //文件长度，字节数
            long fileLength = randomFile.length();
            //读文件的起始位置
            int beginIndex = (fileLength>4)?4:0;
            //将读取文件的开始位置移到beginIndex的位置上
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //一次读取10个字节，如果文件内容不足10个字节，则读取剩下的字节。
            //将一次读取的字节数赋给byteread
            while((byteread = randomFile.read(bytes))!= -1){
                System.out.write(bytes,0,byteread);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(randomFile!=null){
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param in
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void showAvailableBytes(InputStream in){
        try{
            System.out.println("当前字节输入流中的字节数为："+in.available());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部  A方法：使用RandomAccessFile
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName 包含完整路径的文件名
     * @param content 要追加的内容
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void appendToFile_A(String fileName,String content){
        try{
            //打开一个随机访问的文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
            //文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾部
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部  B方法：使用FileWriter
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月6日]
     */
    public static void appendToFile_B(String fileName,String content){
        try{
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName,true);            
            writer.write(content);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将内容追加到文件尾部 C方法：使用BufferedWriter
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017年2月10日]
     */
    public static void appendToFile_C(String fileName,String content){

        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));
            out.write(content);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
