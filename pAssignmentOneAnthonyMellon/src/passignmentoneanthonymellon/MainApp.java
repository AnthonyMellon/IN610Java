package passignmentoneanthonymellon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainApp extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable table;
	private static ArrayList<Song> songList;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Position", "Artist", "Song Title", "Indicative Revenue"
			}
		);
	private JTextField textFieldTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		songList = new ArrayList<Song>(); 
		
		Worker.loadSongs(songList);
		
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	
	public MainApp() {
				
		createPane();
		Worker.drawTable(tm, songList);	
		Worker.createPieTop10(songList, tabbedPane);
		Worker.createPieBottom10(songList, tabbedPane);
		Worker.createLineChart(songList, tabbedPane);
	}	
	
	
	/**
	 * Create the frame.
	 */
	private void createPane()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 84, 760, 435);
		contentPane.add(tabbedPane);
		
		JPanel panelAllItems = new JPanel();
		tabbedPane.addTab("All Items", null, panelAllItems, "A list of all the songs in the dataset");
		panelAllItems.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 735, 335);
		panelAllItems.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		JButton btnSortPos = new JButton("Sort By Position");
		btnSortPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.SortPosition(songList);
				Worker.drawTable(tm, songList);
			}			
		});
		btnSortPos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSortPos.setBounds(10, 346, 180, 50);
		panelAllItems.add(btnSortPos);
		
		JButton btnSortArtist = new JButton("Sort By Artist");
		btnSortArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.SortArtist(songList);
				Worker.drawTable(tm, songList);
			}
		});
		btnSortArtist.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSortArtist.setBounds(190, 346, 180, 50);
		panelAllItems.add(btnSortArtist);
		
		JButton btnSortTitle = new JButton("Sort By Title");
		btnSortTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.SortTitle(songList);
				Worker.drawTable(tm, songList);
			}
		});
		btnSortTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSortTitle.setBounds(369, 346, 180, 50);
		panelAllItems.add(btnSortTitle);
		
		JButton btnSortRevenue = new JButton("Sort By Indicative Revenue");
		btnSortRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Worker.SortRevenue(songList);
				Worker.drawTable(tm, songList);
			}
		});
		btnSortRevenue.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSortRevenue.setBounds(549, 346, 180, 50);
		panelAllItems.add(btnSortRevenue);
		
		JPanel panelIndividualItems = new JPanel();
		tabbedPane.addTab("Individual Items", null, panelIndividualItems, "Show and search for individual songs");
		panelIndividualItems.setLayout(null);
		
		JLabel LabelPosT = new JLabel("Position:");
		LabelPosT.setFont(new Font("Tahoma", Font.BOLD, 36));
		LabelPosT.setBounds(10, 11, 165, 44);
		panelIndividualItems.add(LabelPosT);
		
		JLabel LabelPos = new JLabel("");
		LabelPos.setFont(new Font("Tahoma", Font.BOLD, 36));
		LabelPos.setBounds(177, 11, 563, 44);
		panelIndividualItems.add(LabelPos);
		
		JLabel LabelTitleT = new JLabel("Title:");
		LabelTitleT.setFont(new Font("Tahoma", Font.BOLD, 30));
		LabelTitleT.setBounds(10, 70, 84, 44);
		panelIndividualItems.add(LabelTitleT);
		
		JLabel LabelTitle = new JLabel("");
		LabelTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
		LabelTitle.setBounds(118, 70, 622, 44);
		panelIndividualItems.add(LabelTitle);
		
		JLabel LabelArtistT = new JLabel("Artist:");
		LabelArtistT.setFont(new Font("Tahoma", Font.BOLD, 30));
		LabelArtistT.setBounds(10, 125, 98, 44);
		panelIndividualItems.add(LabelArtistT);
		
		JLabel LabelArtist = new JLabel("");
		LabelArtist.setFont(new Font("Tahoma", Font.BOLD, 36));
		LabelArtist.setBounds(118, 125, 622, 44);
		panelIndividualItems.add(LabelArtist);
		
		JLabel LabelRevenueT = new JLabel("Indicative Revenue:");
		LabelRevenueT.setFont(new Font("Tahoma", Font.BOLD, 26));
		LabelRevenueT.setBounds(10, 180, 269, 44);
		panelIndividualItems.add(LabelRevenueT);
		
		JLabel LabelRevenue = new JLabel("");
		LabelRevenue.setFont(new Font("Tahoma", Font.BOLD, 26));
		LabelRevenue.setBounds(289, 180, 451, 44);
		panelIndividualItems.add(LabelRevenue);
		
		JButton ButtonFirst = new JButton("First");
		ButtonFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.changeItem("First", songList.size());
				Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
			}
		});
		ButtonFirst.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ButtonFirst.setBounds(10, 333, 165, 73);
		panelIndividualItems.add(ButtonFirst);
		
		JButton ButtonLast = new JButton("Last");
		ButtonLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.changeItem("Last", songList.size());
				Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
			}
		});
		ButtonLast.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ButtonLast.setBounds(590, 333, 165, 73);
		panelIndividualItems.add(ButtonLast);
		
		JButton ButtonPrev = new JButton("Previous");
		ButtonPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.changeItem(-1, songList.size());
				Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
			}
		});
		ButtonPrev.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ButtonPrev.setBounds(185, 333, 165, 73);
		panelIndividualItems.add(ButtonPrev);
		
		JButton ButtonNext = new JButton("Next");
		ButtonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.changeItem(1, songList.size());
				Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
			}
		});
		ButtonNext.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ButtonNext.setBounds(415, 333, 165, 73);
		panelIndividualItems.add(ButtonNext);
		
		Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
		
		JLabel lblNewLabel_1 = new JLabel("Search Song Title:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 235, 281, 65);
		panelIndividualItems.add(lblNewLabel_1);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		textFieldTitle.setBounds(299, 235, 338, 65);
		panelIndividualItems.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker.Search(songList, textFieldTitle.getText());
				Worker.updateLabels(songList, LabelPos, LabelArtist, LabelTitle, LabelRevenue);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSearch.setBounds(647, 235, 93, 65);
		panelIndividualItems.add(btnSearch);
		
		JPanel panelStats = new JPanel();
		tabbedPane.addTab("Statistics", null, panelStats, "Statistics on the indicative revenue for songs in the dataset");
		panelStats.setLayout(null);
		
		JLabel lblMaxRevT = new JLabel("Max Indicative Revenue:");
		lblMaxRevT.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMaxRevT.setBounds(10, 11, 356, 36);		
		panelStats.add(lblMaxRevT);		
		
		JLabel lblMinRevT = new JLabel("Min Indicative Revenue:");
		lblMinRevT.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMinRevT.setBounds(10, 58, 356, 36);
		panelStats.add(lblMinRevT);
		
		JLabel lblMeanRevT = new JLabel("Mean Indicative Revenue:");
		lblMeanRevT.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMeanRevT.setBounds(10, 105, 356, 36);
		panelStats.add(lblMeanRevT);
		
		JLabel lblMedianRevT = new JLabel("Median Indicative Revenue:");
		lblMedianRevT.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMedianRevT.setBounds(10, 152, 356, 36);
		panelStats.add(lblMedianRevT);
		
		JLabel lblMaxRev = new JLabel("");
		lblMaxRev.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMaxRev.setBounds(389, 11, 356, 36);
		lblMaxRev.setText(Worker.FindMaxRev(songList));
		panelStats.add(lblMaxRev);
		
		JLabel lblMinRev = new JLabel("");
		lblMinRev.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMinRev.setBounds(389, 58, 356, 36);
		lblMinRev.setText(Worker.FindMinRev(songList));
		panelStats.add(lblMinRev);
		
		JLabel lblMeanRev = new JLabel("");
		lblMeanRev.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMeanRev.setBounds(389, 105, 356, 36);
		lblMeanRev.setText(Worker.FindMeanRev(songList));
		panelStats.add(lblMeanRev);
		
		JLabel lblMedianRev = new JLabel("");
		lblMedianRev.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMedianRev.setBounds(389, 152, 356, 36);
		lblMedianRev.setText(Worker.FindMedianRev(songList));
		panelStats.add(lblMedianRev);
		
		JLabel lblNewLabel = new JLabel("Song Ratings From Early 2000s");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 11, 745, 69);
		contentPane.add(lblNewLabel);
	}
}
