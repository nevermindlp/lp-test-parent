package lp.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * Created by lvpeng01 on 2018/4/9.
 */
public class LpClassLoader extends ClassLoader {

    private String classFilePath;

    public LpClassLoader(String diskPath) {
        classFilePath = diskPath;
    }

    /**
     * eg: name = "lp.classloader.external.Hello"
     *
     * ByteArrayOutputStream is a virtual stream, so you do not need to close it.
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFullPath = classFilePath + getFileName(name);
        File file = new File(classFullPath);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] fileBytes = IOUtils.toByteArray(fis);
            IOUtils.closeQuietly(fis);
            return defineClass(name, fileBytes, 0, fileBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }


}
