import java.io.*;

public class HexVisor {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the filename: ");
        String filename = null;
        try {
            filename = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (filename == null || filename.isEmpty()) {
            System.out.println("No filename provided.");
            return;
        }

        try (InputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            int offset = 0;
            int bytesRead;
            byte[] buffer = new byte[16];

            while ((bytesRead = is.read(buffer)) != -1) {
                System.out.printf("Offset %08X: ", offset);

                for (int i = 0; i < bytesRead; i++) {
                    System.out.printf("%02X ", buffer[i] & 0xFF);
                }

                // If less than 16 bytes read, fill the remaining space with spaces
                for (int i = bytesRead; i < 16; i++) {
                    System.out.print("   ");
                }

                System.out.print("  ");

                // Print ASCII representation
                for (int i = 0; i < bytesRead; i++) {
                    char c = (char) buffer[i];
                    if (Character.isISOControl(c) || c == '\n' || c == '\r' || c == '\t') {
                        System.out.print(".");
                    } else {
                        System.out.print(c);
                    }
                }

                System.out.println();
                offset += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}