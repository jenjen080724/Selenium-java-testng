package Java_Tester;
//Kiem tra he dieu hanh loai nao: Window,Mac, Unix,Linux,Fedora,Mint
public class Topic_03_System_Info {
    public static void main(String args[]){
        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
