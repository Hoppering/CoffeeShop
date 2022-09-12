package com.mienekleinepupkin.CoffeeShop.storage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageFile {

  public String saveFile(MultipartFile file) throws IOException {
    String folder = System.getProperty("user.dir");
    byte[] bytes = file.getBytes();
    String imageName = new Date().getTime() + file.getOriginalFilename();
    Path path = Paths.get(folder + "/files/" + imageName);
    Files.write(path, bytes);
    return path.getFileName().toString();
  }

  public ByteArrayResource getFileByteArrayResource(String fileName) throws IOException {
    String folder = System.getProperty("user.dir");
    File file = new File(folder + "/files/" + fileName);
    Path path = Paths.get(file.getAbsolutePath());
    return new ByteArrayResource(Files.readAllBytes(path));
  }

  public File getFile(String fileName) {
    String folder = System.getProperty("user.dir");
    return new File(folder + "/files/" + fileName);
  }

  public void deleteFile(String fileName) throws IOException {
    String folder = System.getProperty("user.dir");
    Files.deleteIfExists(Path.of(folder + "/files/" + fileName));
  }

}
