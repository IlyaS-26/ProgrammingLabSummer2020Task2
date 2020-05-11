import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileFinderTests {
    FileFinder fileFind = new FileFinder();

    File currentDirectory = new File(new File(".").getAbsolutePath());
    File testFileOne = new File(currentDirectory + "//directoryForTests//testDirectoryOne", "testFileOne");
    File testFileTwo = new File(currentDirectory + "//directoryForTests//testDirectoryTwo", "testFileTwo");
    File testFileThree = new File(currentDirectory + "//directoryForTests", "testFileThree");
    File Test = new File(currentDirectory, "Test.txt");

    @Test
    public void test1() throws Exception {
        assertEquals("Файл testFileTwo не найден.",
                fileFind.run(new String[]{"-d", String.valueOf(currentDirectory), "testFileTwo"}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals("Файл testFileTwo найден." + "\n" + "Путь: " + testFileTwo.getAbsolutePath(),
                fileFind.run(new String[]{"-r", "-d", String.valueOf(currentDirectory), "testFileTwo"}));
    }

    @Test
    public void test3() throws Exception {
        assertEquals("Файл testFileOne найден." + "\n" + "Путь: " + testFileOne.getAbsolutePath(),
                fileFind.run(new String[]{"-r", "testFileOne"}));
    }

    @Test
    public void test4() throws Exception {
        assertEquals("Файл testFileThree найден." + "\n" + "Путь: " + testFileThree.getAbsolutePath(),
                fileFind.run(new String[]{"-r", "testFileThree"}));
    }

    @Test
    public void test5() throws Exception {
        assertEquals("Файл testFileFour не найден.",
                fileFind.run(new String[]{"-r", "-d", String.valueOf(currentDirectory), "testFileFour"}));
    }

    @Test
    public void test6() throws Exception {
        assertEquals("Файл Test.txt найден." + "\n" + "Путь: " + Test.getAbsolutePath(),
                fileFind.run(new String[]{"-d", String.valueOf(currentDirectory), "Test.txt"}));
    }
}