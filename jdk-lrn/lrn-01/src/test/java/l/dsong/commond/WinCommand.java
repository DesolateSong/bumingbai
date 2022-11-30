package l.dsong.commond;


import org.junit.jupiter.api.Test;

import java.io.*;

public class WinCommand {

    public static int executeCommand(String[] cmd, String baseFolder) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);

        processBuilder.environment().put("MYSQL_HOME", "D:\\MYSQL\\mysql-8.0.28-winx64\\bin");

        if (baseFolder != null && baseFolder.length() > 0)
            processBuilder.directory(new File(baseFolder));
        Process exec = null;
        exec = processBuilder.start();
        // 获取外部程序标准输出流
        new Thread(new OutputHandlerRunnable(exec.getInputStream(), false)).start();
        // 获取外部程序标准错误流
        new Thread(new OutputHandlerRunnable(exec.getErrorStream(), true)).start();

        int code = 0;
        code = exec.waitFor();

        System.out.println(code);
        exec.destroy();
        return code;
    }

    @Test
    public void cmd1() {
        String[] cmd = new String[]{"ipconfig"};
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);

        processBuilder.directory(new File("e:\\temp"));

        processBuilder.environment().forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        Process exec = null;
        try {
            exec = processBuilder.start();
            // 获取外部程序标准输出流
            new Thread(new OutputHandlerRunnable(exec.getInputStream(), false)).start();
            // 获取外部程序标准错误流
            new Thread(new OutputHandlerRunnable(exec.getErrorStream(), true)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int code = 0;
        try {
            code = exec.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(code);

    }


    @Test
    public void cmd2() {
        try {
//            executeCommand(new String[]{"java", "-version"}, "e:\\temp");
//            executeCommand(new String[]{"echo", "%MYSQL_HOME%"}, "e:\\temp");
//            executeCommand(new String[]{"mysqldump", "-uroot", "-proot", "--hex-blob", "mydb", "-r", "\"mydb1.sql\""}, "e:\\temp");

//            executeCommand(new String[]{"7z","a","mydb1.zip" , "mydb1.sql"}, "e:\\temp");
            executeCommand(new String[]{"ipconfig"}, "e:\\temp");

//            execCommand("cmd /C del /a/f/q " + zipFileName, baseFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static class OutputHandlerRunnable implements Runnable {
        private InputStream in;

        private boolean error;

        public OutputHandlerRunnable(InputStream in, boolean error) {
            this.in = in;
            this.error = error;
        }

        @Override
        public void run() {
            try (BufferedReader bufr = new BufferedReader(new InputStreamReader(this.in))) {
                String line = null;
                while ((line = bufr.readLine()) != null) {
//                    if (error) {
                        System.out.println(line);
//                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileTest(){

        File file= new File("D:\\VM_OSs\\CentOS-Stream-9-latest-x86_64-boot.iso");

        System.out.println(file.length());

        // 866_123_776
        // 524_288_000

        System.out.println(1%500);

    }

}
