import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class ShkruajEmrinNeASCII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Shkruani emrin: ");
		String emri = sc.nextLine().toUpperCase();
		System.out.print("Shkruani karakterin: ");
		String ch = sc.next();
		output(emri, ch);
		sc.close();
	}

	private static void output(String emri, String karakteri) {
		int width = 100;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 14));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(emri, 5, 20);
		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {
				sb.append(image.getRGB(x, y) == -16777216 ? " " : karakteri);
			}
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
			System.out.println(sb);
		}
	}
}