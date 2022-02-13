package lib.methods.any_methods;

import io.qameta.allure.Attachment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Logger {

    private final String pathName = "target\\logs\\";
    private String logsFileName;
    private final String pathToLogsDirectory = new File(pathName).getAbsolutePath() + "\\";
    private String testName;
    private List<String> assertErrors;

    public Logger(String testName, List<String> assertErrors) {
        this.assertErrors = assertErrors;
        this.testName = testName;
    }

    @Attachment(value = "Assert bodies logs", type = "text/plain")
    public byte[] getAssertBodiesReportLogs() {
        logsFileName = testName + "-" + getSystemTime() + ".txt";
        try {
            Path pathToAndroidLogs = createAndroidLogsFile();
            writeAndroidLogsFile();
            return Files.readAllBytes(pathToAndroidLogs);
        } catch (Exception e) {
            throw new RuntimeException("Cannot write logs to file" + e.getMessage());
        }
    }

    private Path createAndroidLogsFile() throws IOException {
        return Files.createFile(Paths.get(pathToLogsDirectory, logsFileName));
    }

    private void writeAndroidLogsFile() throws Exception {
        FileWriter writer = new FileWriter(pathToLogsDirectory + logsFileName);
        BufferedWriter bw = new BufferedWriter(writer);
        for (String str : assertErrors) {
            bw.write(str + System.lineSeparator());
        }
        bw.close();
    }

    private long getSystemTime() {
        return System.currentTimeMillis();
    }
}
