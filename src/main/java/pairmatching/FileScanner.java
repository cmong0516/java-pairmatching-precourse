package pairmatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pairmatching.constans.FileRoot;

public class FileScanner {
    private List<String> backEndCrews;
    private List<String> frontEndCrews;

    public FileScanner() {

        try {
            this.backEndCrews = readFile(FileRoot.BACKEND_FILE_ROOT.getFileRoot());
            this.frontEndCrews = readFile(FileRoot.FRONTEND_FILE_ROOT.getFileRoot());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<String> readFile(String fileRoot) throws IOException {
        return Files.readAllLines(Paths.get(fileRoot));
    }

    public List<String> getBackEndCrews() {
        return backEndCrews;
    }

    public List<String> getFrontEndCrews() {
        return frontEndCrews;
    }
}
