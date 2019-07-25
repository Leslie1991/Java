package com.mypro.basecomponet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.mypro.mainsurface.MainSurface;
import com.mypro.manager.CannonManager;
import com.mypro.manager.GameInitManager;
import com.mypro.manager.LayoutManager;
import com.mypro.model.GamingInfo;

import static javax.swing.JOptionPane.showConfirmDialog;

public class AwtMainComponet{
	public static void main(String[] args) throws Exception  {
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		JFrame frame = new JFrame();
		GamingInfo.getGamingInfo().setGaming(true);
		GamingInfo.getGamingInfo().setScreenWidth(900);
		GamingInfo.getGamingInfo().setScreenHeight(600);
		frame.setSize(GamingInfo.getGamingInfo().getScreenWidth(), GamingInfo.getGamingInfo().getScreenHeight());
//    	frame.setUndecorated(true); // ȥ�����ڵ�װ��
//    	frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);//����ָ���Ĵ���װ�η��
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		MainSurface pane = new MainSurface();
		GamingInfo.getGamingInfo().setSurface(pane);
//		Label scoreLabel=new JLabel("��߷֣�200");
//		scoreLabel.setForeground(Color.blue);
//		scoreLabel.setVisible(true);
//		scoreLabel.setOpaque(true);
//		scoreLabel.setSize(600,200);
//		scoreLabel.setDisplayedMnemonic(-1);

		Label scoreLabel=new Label("��߷֣�"+GamingInfo.getGamingInfo().getHighestScore());
		scoreLabel.setBackground(new Color(0,80,0,0));
		scoreLabel.setForeground(new Color(255,0,0));
		pane.add(scoreLabel);
		frame.setContentPane(pane);
//		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int flag=JOptionPane.showConfirmDialog(pane,"�Ƿ��˳���","��ʾ",JOptionPane.OK_CANCEL_OPTION);
				if(flag==0) {
					int score = GamingInfo.getGamingInfo().getScore();
					if (score > GamingInfo.getGamingInfo().getHighestScore()) {
						GamingInfo.getGamingInfo().setHighestScore(score);
						JOptionPane.showConfirmDialog(pane,"�¼�¼��"+score,"��ϲ",JOptionPane.OK_CANCEL_OPTION);
					}
					System.exit(0);
				}
			}
		});
		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(GameInitManager.getGameInitManager().isIniting()){
					return ;
				}
				//�ȿ����ֹ������Ƿ�����Ӧ
				if(!LayoutManager.getLayoutManager().onClick(e.getX(), e.getY())){
					//�����ӵ�
					CannonManager.getCannonManager().shot(e.getX(),  e.getY());
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
//		frame.pack();
		pane.action();
		/**
		 * ����һ���߳����첽��ʼ����Ϸ����
		 */
		new Thread(new Runnable(){

			public void run() {
				//ʹ����Ϸ��ʼ����������ʼ����Ϸ
				GameInitManager.getGameInitManager().init();
			}

		}).start();
	}

}