import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex16_예외던지기_throws {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // 'FileReader'를 사용하려고 하면 반드시 'throws'가 필요하다.
        BufferedReader breader = new BufferedReader(new FileReader("out.txt"));

        // 'throws FileNotFoundException'
        // ~> 생성자 'FileReader'의 인자 'fileName'의 값에 해당하는 파일이 디렉토리이거나 어떤 이유로 사용할 수 없다면
        // 'FileNotFoundException'을 발생시킨다는 의미

        // 이것은 'fileReader'의 생성자가 동작할 때, 파일을 열 수 없는 경우가 생길수 있고,
        // 이런 경우 'fileReader' 생성자에서는 이 문제를 처리할 수 없기 때문에,
        // 이에 대한 처리를 생성자를 사용하는 사용자에게 위임하겠다는 의미이다.

        // 이 'throws FileNotFoundException, IOException'는 다음과 같은 의미이다.
        BufferedReader bReader = null;
        String input = null;
        try {
            bReader = new BufferedReader(new FileReader("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            input = bReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        // 'FileReader'는 'FileNotFoundException'을, 'readLine'는 'IOException'을 발생시킨다.

        System.out.println(input);
    }
}

