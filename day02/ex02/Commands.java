package ex02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Commands {
	private final Path currentPath;

	public Commands(Path currentPath) throws IOException {
		System.out.println(currentPath);
		if (Files.exists(currentPath)) {
			throw new IOException("File not found"); // TODO: check
		}
		this.currentPath = currentPath;
	}

	public void mv(Path from, Path to) {
		try {
			Path fromAbsolute = Paths.get(this.currentPath + "/" + from);
			Path toAbsolute = Paths.get(this.currentPath + "/" + to);

			if (Files.isRegularFile(fromAbsolute)) {
				if (Files.isDirectory(toAbsolute)) {
					toAbsolute = Paths.get(toAbsolute + "/" + fromAbsolute.getFileName());
				Files.move(fromAbsolute, toAbsolute, REPLACE_EXISTING);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void ls() {
		List<Path> files;


	}

	public void cd() {

	}

	public Path getCurrentPath() {
		return currentPath;
	}
}
