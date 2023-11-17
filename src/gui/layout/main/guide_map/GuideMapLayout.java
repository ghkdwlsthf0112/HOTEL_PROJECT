package gui.layout.main.guide_map;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import image.getImages;

public class GuideMapLayout extends JFrame {
	static JLabel floorLabel;
	static ImageIcon[] imagesLabel;
	int currentIndex = 0;

	public GuideMapLayout() {
		
		// 이미지 개수
		int numImages = 4;
		imagesLabel = new ImageIcon[numImages];
		
		for (int i = 0; i < numImages; i++) {
			imagesLabel[i] = new getImages().getImageIcon
					(768, 1024, "src/image/hotel_image/프레스티지 스위트" + (i + 1) + ".jpg");
		}
		
		
		floorLabel = new JLabel(imagesLabel[0]);
		JPanel btnPanel = new JPanel();
		for (int i = 0; i < imagesLabel.length; i++) {
			JButton floorBtn = new JButton((i + 1) + "층");
			int finalI = i;
			floorBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					currentIndex = finalI;
					floorLabel.setIcon(imagesLabel[currentIndex]);
				}
			});
			btnPanel.add(floorBtn);
		}
		setLayout(null);
		btnPanel.setBounds(180, 100, 400, 100);
		floorLabel.setBounds(100, 350, 600, 600);
		add(btnPanel);
		add(floorLabel);
		setTitle("층별 안내도");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GuideMapLayout();
	}
}
