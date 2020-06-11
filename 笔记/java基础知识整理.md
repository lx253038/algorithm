# java基础知识整理

## IO

### 字符流

> ####  Reader  :字符输入流
> - FileReader：文件类型的字符输入流【fileReader.read()读取一个字符，直到-1读取完毕】
>
> ```java
> FileReader fileReader = new FileReader("demo.txt");
> //循环去读取所有字符，知道返回结果为-1（有多少字符循环多少次）
> while ((len = fileReader.read()) != -1) {  
>     System.out.print((char) len);
>  }
>  =======================================================
>   //将每次读取的字符放到字符数组中，
>   char[] arr = new char[16];     
>   //read返回读取字符的个数,且每次最多读取个数为数组长度
>   int read = fileReader.read(arr);
>   //由于不确定输入流的字符数，可能出现数组长度小于字符数即一次不能全部读取，
>   //使用while循环全部读取
>   while ((len = fileReader.read(arr)) != -1) {
>      System.out.print(new String(arr, 0, len));
>   }           
>            
> ```
> - BufferedReader：带缓冲区的字符输入流【bufferedReader.readLine()按行读取字符，直到null读取完毕】
>
> ```java
> FileReader fileReader = new FileReader("demo.txt");
> BufferedWriter bufferedWriter =  new BufferedReader(fileReader);
> String str;
> while ((str = bufferedReader.readLine()) != null) {
>     System.out.print(new String(arr, 0, len));
> }     
> ```
> 
>#### Writer :字符输出流
> - FileWriter：文件类型的字符输出流
> 
> ```java
>//append 是否在原有内容上进行拼接
> FileWriter fileWriter = new FileWriter("demo.txt", true);  
> fileWriter.write("abcdefg1233");
> ```
> 
> - BufferedWriter：带缓冲区的字符输出流 
>```java
> FileWriter fileWriter = new FileWriter("copy_demo.txt");
> BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
> bufferedWriter.write("1223434545657587"); //将字符串写入到文件中
> bufferedWriter.newLine(); //换行
> bufferedWriter.flush();   //将缓冲区数据刷新到文件中
> ```

### 字节流

> ####  InputStream  :字节输入流
> - FileInputStream：文件类型的字节输入流
>
> ```java
> InputStream inputStream = inputStream = new FileInputStream("photo.png");
> //获取文件大小
> System.out.println(inputStream.available() / 1024 + "kb");
> byte[] bytes = new byte[1024];  //创建字节数组读取流
> int read;
> while ((read = inputStream.read(bytes)) != -1) {
>    System.out.println(new String(bytes,0,read));  
> }    
> ```
> - BufferedInputStream：带缓冲区的字节输入流
>
> ```java
> FileInputStream fis = new FileInputStream("photo.png");
> BufferedInputStream bis = new BufferedInputStream(fis);
> int len;
> while ((len = bis.read()) != -1) {
> }
> ```
>
> #### OutputStream :字节输出流
> - FileOutputStream：文件类型的字节输出流
>
> ```java
> OutputStream outputStream = new FileOutputStream("copyPh.jpg")
> byte[] bytes = new byte[1024];  //创建字节数组读取流
> outputStream.write(bytes, 0, read);   //通过输出流将字节写入文件
> ```
>
> - BufferedOutputStream：带缓冲区的字节输出流 
> ```java
> FileOutputStream fos = new FileOutputStream("copy2.jpg");
> BufferedOutputStream bos = new BufferedOutputStream(fos); 
> bos.write(len);
> bos.flush();
> ```
> #### 文件字节流实现文件拷贝
>
> ```java
> InputStream inputStream = new FileInputStream("photo.png");
> OutputStream outputStream = new FileOutputStream("copyPh.jpg");
> byte[] bytes = new byte[1024];  //创建字节数组读取流
> int read;
> while ((read = inputStream.read(bytes)) != -1) {
>     outputStream.write(bytes, 0, read);   //通过输出流将字节写入文件
> }
> ```
> #### 缓冲字节流实现文件拷贝
>
> ```java
> FileInputStream fis = new FileInputStream("photo.png");
> FileOutputStream fos = new FileOutputStream("copy2.jpg");
> BufferedInputStream bis = new BufferedInputStream(fis);
> BufferedOutputStream bos = new BufferedOutputStream(fos);
> int len;
> while ((len = bis.read()) != -1) {
>     bos.write(len);
>     bos.flush();
> }
> ```

### 转换流（字节流和字符流的相互转换）

>  #### InputStreamReader：（继承自Reader）接收一个InputStream类型的输入流（字符集可选）
>
>  #### OutputStreamWriter：（继承自Writer）接收一个OutputStream类型的输出流（字符集可选）
>
>  ```java
>  //1.键盘录入数据写入到文件
>  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
>  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test111.txt")));
>  //2.将文本内容输出到控制台
>  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
>  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
>  //3.将文件中内容拷贝到另一个文件中
>  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test111.txt")));
>  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy_test111.txt")));
>  ```