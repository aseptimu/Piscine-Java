package ex02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Commands {
	private Path currentPath;

	public Commands(Path currentPath) throws IOException {
		System.out.println(currentPath);
		if (!Files.exists(currentPath)) {
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
				}
				Files.move(fromAbsolute, toAbsolute, REPLACE_EXISTING);
			} else {
				System.out.println("Wrong file");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void ls() {
		try (Stream<Path> paths = Files.walk(currentPath, 1)) {
			paths
					.filter(path -> !path.getFileName().toString().startsWith(".") && !path.equals(currentPath))
					.forEach(path -> {
						try {
							System.out.println(path.getFileName() + " " +
									(long)Math.ceil((double)Files.size(path) / 1024) + " KB");
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void cd(Path to) {
		Path fullPath = Paths.get(currentPath.toString() + "/" + to.toString());
		if (Files.exists(fullPath) && Files.isDirectory(fullPath)) {
			currentPath = fullPath.normalize();
			System.out.println(currentPath);
		} else {
			System.out.println("Wrong directory");
		}
	}
}
