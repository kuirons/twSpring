package util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

/** @Author: kuirons @Date: 18-1-18 */
public class FileUtil {
  static File[] fileFilter(String url) {
    File dir = new File(url);
    FileFilter filter = new WildcardFileFilter("plane*");
    return dir.listFiles(filter);
  }

  static List<String> readFile(String url) throws IOException {
      return FileUtils.readLines(new File(url),"utf-8");
  }
}
