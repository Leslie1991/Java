package com.mypro.model;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

import com.mypro.constant.Constant;
import com.mypro.mainsurface.MainSurface;
import com.mypro.manager.ShoalManager;
//import com.mypro.manager.SoundManager;
import com.mypro.model.fish.Fish;

//��Ϸ������һЩ��Ҫ���õı���
public class GamingInfo {
	private int screenWidth;
	private int screenHeight;
	private static GamingInfo gameInfo; // ����ģʽ��Ҫ
	private boolean isGaming; // �Ƿ�����Ϸ״̬
	private boolean isPause;//�Ƿ�����ͣ״̬
	private MainSurface surface; // ����Ļ
	private ArrayList<Fish> fish = new ArrayList<Fish>(); // ���е���
	private ShoalManager shoalManager; // ��Ⱥ������
	private float cannonLayoutX;			//������תX����
	private float cannonLayoutY;			//������תY����
	private int score = 100;//��ǰ�ķ�
	private int highestScore;//��߷�

	/**
	 *
	 * @return ���ļ�������߷֣����ǵ�ǰ�ĵ���߷�
	 */
	public int getHighestScoreFromeFile(){
		File file=new File(Constant.HIGHEST_SCORE_PATH);
		try {
			if(file.exists()){
				Scanner scanner=new Scanner(file);
				highestScore=scanner.nextInt();
				scanner.close();
				return highestScore;

			}else{
				file.createNewFile();
				highestScore=0;
				return 0;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;

	}
	public int getHighestScore() {
		return highestScore;
	}

	/**
	 * ������߷֣���д�뵽�ļ���
	 * @param highestScore
	 */
	public void setHighestScore(int highestScore) {
		File file=new File(Constant.HIGHEST_SCORE_PATH);
		try {
			file.createNewFile();
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write(highestScore+"");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.highestScore = highestScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * ���GamingInfoʵ��
	 */
	public static void clearGameInfo() {
		gameInfo = null;
	}

	private GamingInfo() {
		getHighestScoreFromeFile();
	}

	public static GamingInfo getGamingInfo() {
		if (gameInfo == null) {
			gameInfo = new GamingInfo();
		}
		return gameInfo;
	}

	public boolean isGaming() {
		return isGaming;
	}

	public void setGaming(boolean isGaming) {
		this.isGaming = isGaming;
	}

	public ArrayList<Fish> getFish() {
		return fish;
	}

	public void setFish(ArrayList<Fish> fish) {
		this.fish = fish;
	}

	public MainSurface getSurface() {
		return surface;
	}

	public void setSurface(MainSurface surface) {
		this.surface = surface;
	}

	public ShoalManager getShoalManager() {
		return shoalManager;
	}

	public void setShoalManager(ShoalManager shoalManager) {
		this.shoalManager = shoalManager;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public float getCannonLayoutX() {
		return cannonLayoutX;
	}

	public void setCannonLayoutX(float cannonLayoutX) {
		this.cannonLayoutX = cannonLayoutX;
	}

	public float getCannonLayoutY() {
		return cannonLayoutY;
	}

	public void setCannonLayoutY(float cannonLayoutY) {
		this.cannonLayoutY = cannonLayoutY;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

}