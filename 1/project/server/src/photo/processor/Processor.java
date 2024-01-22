package photo.processor;

import photo.bean.PhotoData;

public class Processor {

  static final String PHOTO = "PHOTO";

  PhotoData photoData;

  Processor() {

  }

  PhotoData getSalarySystem() {
    return photoData;
  }

  void setSalarySystem(PhotoData photoData) {
    this.photoData = photoData;
  }

  public static PhotoData loadModel() {
    Loader reader = new Loader();
    return reader.load();
  }

  public static void saveModel(PhotoData photoData) {
    Persister writer = new Persister();
    writer.store(photoData);
  }

  String getFile() {
    return this.getClass().getClassLoader().getResource("txt/data.txt").getPath();
  }

}
