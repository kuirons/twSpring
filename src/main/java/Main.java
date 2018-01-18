import config.PositonConfig;
import logic.plane.PlaneManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  private PlaneManager planeManager = new PlaneManager();
  private PositonConfig positonConfig = new PositonConfig();

  public static void main(String[] args) throws Exception {
    Main main = new Main();
    main.positonConfig.load(String.valueOf(Main.class.getResource("")).replace("file:", ""));
    main.planeManager.create(main.positonConfig);

    BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = null;
    while ((line = bufr.readLine()) != null) {
      if ("exit".equals(line)) break;
      if (!line.matches("^[1-9]\\d*$|0")) System.out.println("Inputting illicit");
      else System.out.println(main.planeManager.selectInfo(Integer.parseInt(line)));
    }
    bufw.close();
  }
}
