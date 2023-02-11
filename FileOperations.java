package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import javax.sound.midi.Patch
public class FileOperations {

		public static void main(String[] args) throws IOException {
			String fileName = "D:\\task\\src\\task\\FileOperations.java";
			FileOperations fileOperations = new FileOperations();
			fileOperations.printTheFile(fileName);
			fileOperations.countTheLines(fileName);
			fileOperations.copyFiles(fileName);
			fileOperations.findFilePath(fileName);

		}

		private void findFilePath(String fileName) throws IOException {
			File file = new File(fileName);
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("Canonical Path: " + file.getCanonicalPath());
			System.out.println("Path: " + file.getPath());
			
		}

		private void copyFiles(String fileName) throws IOException {
			 File sourceFile = new File("D:\\task\\src\\task\\FileOperations.java");
		        File copyFile = new File("D:\\task\\src\\task\\FileOperationsCopy.txt");
		             
		        // using copy(InputStream,Path Target); method
		        Files.copy(sourceFile.toPath(), copyFile.toPath());
		        System.out.println("File Copied Successfully");
			
		}

		private void countTheLines(String fileName) {
			long lines = 0;
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				while (reader.readLine() != null)
					lines++;
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Number Of Lines in File "+lines);

		}

		private void printTheFile(String fileName) {
			try {
				FileReader fileReader = new FileReader(fileName);
				int index;
				while ((index = fileReader.read()) != -1)

					System.out.print((char) index);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}


