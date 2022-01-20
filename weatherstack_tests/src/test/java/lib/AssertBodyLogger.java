package lib;

import io.qameta.allure.Attachment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AssertBodyLogger extends CoreTestCase {

    private static String logsFileName;
    private static final String pathToLogsDirectory = new File("target\\logs\\assert_bodies_logs\\").getAbsolutePath() + "\\";
    private static String testName;
    private static List<String> assertErrors;

    public AssertBodyLogger(String testName, List<String> assertErrors) {
        AssertBodyLogger.assertErrors = assertErrors;
        AssertBodyLogger.testName = testName;
    }

    @Attachment(value = "Assert bodies logs", type = "text/plain")
    public static byte[] getAssertBodiesReportLogs() {
        logsFileName = "body_assertion-" + testName + "-" + getSystemTime() + ".txt";
        try {
            Path pathToAndroidLogs = createAndroidLogsFile();
            writeAndroidLogsFile();
            return Files.readAllBytes(pathToAndroidLogs);
        } catch (Exception e) {
            throw new RuntimeException("Cannot write logs to file" + e.getMessage());
        }
    }

    private static Path createAndroidLogsFile() throws IOException {
        return Files.createFile(Paths.get(pathToLogsDirectory, logsFileName));
    }

    private static void writeAndroidLogsFile() throws Exception {
        FileWriter writer = new FileWriter(pathToLogsDirectory + logsFileName);
        BufferedWriter bw = new BufferedWriter(writer);
        for (String str : assertErrors) {
            bw.write(str + System.lineSeparator());
        }
        bw.close();
    }

    private static long getSystemTime() {
        return System.currentTimeMillis();
    }
}
