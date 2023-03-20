import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writer {
    // This class will to a file with passes parameters from main

    private FileWriter fileWriter;

    public writer(String filename) throws IOException {
        fileWriter = new FileWriter(filename);
    }

    public void writePet(Pet pet) throws IOException {
        fileWriter.write(pet.getName() + " " + pet.getAge() + " " + pet.getType() + "\n");
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}


