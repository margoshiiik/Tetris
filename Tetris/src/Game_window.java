import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game_window extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;

    private BufferedImage blocks, background, pause, refresh, crystal, music, toMenu;

    //board dimensions (the playing area)

    private final int boardHeight = 20, boardWidth = 10;

    // block size

    private final int blockSize = 30;

    // field

    private Clip clip;

    private int[][] board = new int[boardHeight][boardWidth];

    // array with all the possible shapes

    private Shape[] shapes = new Shape[7];

    // currentShape

    private static Shape currentShape, nextShape;

    // game loop

    private Timer looper;

    private int FPS = 60;

    private int delay = 1000/FPS;

    // mouse events variables

    private int mouseX, mouseY;

    private boolean leftClick = false;

    private Rectangle stopBounds, refreshBounds, musicBounds, backToMenu;

    private boolean gamePaused = false;

    private boolean gameOver = false;

    // buttons press lapse

    private int currentScore;

    private int lineQuantity = 0;

    private JFrame frame;

    private boolean isMusicPlaying;

    private boolean isTrue = true;


    private Timer buttonLapse = new Timer(300, new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonLapse.stop();
        }});

    // score

    private int score = 0;


    public Game_window(JFrame frame){
        blocks = ImageLoader.loadImage("tiles.png");

        music = ImageLoader.loadImage("stop.png");

        background = ImageLoader.loadImage("background.jpg");
        pause = ImageLoader.loadImage("pause.png");
        refresh = ImageLoader.loadImage("refresh.png");
        crystal = ImageLoader.loadImage("crystal.png");
        toMenu = ImageLoader.loadImage("home.png");


        mouseX = 0;
        mouseY = 0;

        this.frame = frame;

        stopBounds = new Rectangle(325, 450, 70, 70);
        refreshBounds = new Rectangle(325, 450 - refresh.getHeight() - 20,70, 90);

        musicBounds = new Rectangle(410, 450 - refresh.getHeight() - 20, 70, 90);

        backToMenu = new Rectangle(410, 450, 90, 90);

        // create game looper

        looper = new Timer(delay, new GameLooper());

        // create shapes

        shapes[0] = new Shape(new int[][]{
                {1, 1, 1, 1}   // I shape;
        }, blocks.getSubimage(0, 0, blockSize, blockSize), this, 1);

        shapes[1] = new Shape(new int[][]{
                {1, 1, 1},
                {0, 1, 0},   // T shape;
        }, blocks.getSubimage(blockSize, 0, blockSize, blockSize), this, 2);

        shapes[2] = new Shape(new int[][]{
                {1, 1, 1},
                {1, 0, 0},   // L shape;
        }, blocks.getSubimage(blockSize*2, 0, blockSize, blockSize), this, 3);

        shapes[3] = new Shape(new int[][]{
                {1, 1, 1},
                {0, 0, 1},   // J shape;
        }, blocks.getSubimage(blockSize*3, 0, blockSize, blockSize), this, 4);

        shapes[4] = new Shape(new int[][]{
                {0, 1, 1},
                {1, 1, 0},   // S shape;
        }, blocks.getSubimage(blockSize*4, 0, blockSize, blockSize), this, 5);

        shapes[5] = new Shape(new int[][]{
                {1, 1, 0},
                {0, 1, 1},   // Z shape;
        }, blocks.getSubimage(blockSize*5, 0, blockSize, blockSize), this, 6);

        shapes[6] = new Shape(new int[][]{
                {1, 1},
                {1, 1},   // O shape;
        }, blocks.getSubimage(blockSize*6, 0, blockSize, blockSize), this, 7);

    }



    private void update(){
        if(stopBounds.contains(mouseX, mouseY) && leftClick && !buttonLapse.isRunning() && !gameOver)
        {
            buttonLapse.start();
            gamePaused = !gamePaused;
        }

        if(refreshBounds.contains(mouseX, mouseY) && leftClick ){
            clip.close();
            startGame();
        }


        if(musicBounds.contains(mouseX,mouseY) && leftClick){
            clip.close();
            isMusicPlaying = !isMusicPlaying;
        }

        if(musicBounds.contains(mouseX,mouseY) && leftClick && !isMusicPlaying){
            playMusic();
        }

        if(backToMenu.contains(mouseX,mouseY) && leftClick && isTrue){
            clip.close();

            this.getFrame().setVisible(false);
            this.setVisible(false);

            isTrue = false;
            Main_window main_window = new Main_window();
            main_window.setLocationRelativeTo(null);
            main_window.setVisible(true);
            main_window.playMusic();
        }

        if(gamePaused || gameOver)
        {
            return;
        }
        currentShape.update();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);


        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col ++)
            {

                if(board[row][col] != 0)
                {

                    g.drawImage(blocks.getSubimage((board[row][col] - 1)*blockSize,
                            0, blockSize, blockSize), col*blockSize, row*blockSize, null);
                }

            }
        }

        for(int row = 0; row < nextShape.getCoords().length; row ++)
        {
            for(int col = 0; col < nextShape.getCoords()[0].length; col ++)
            {
                if(nextShape.getCoords()[row][col] != 0)
                {
                    g.drawImage(nextShape.getBlock(), col*30 + 320, row*30 + 50, null);
                }
            }
        }
        currentShape.render(g);

        if(stopBounds.contains(mouseX, mouseY))
            g.drawImage(pause.getScaledInstance(pause.getWidth() + 3, pause.getHeight() + 3, BufferedImage.SCALE_DEFAULT)
                    , stopBounds.x + 3, stopBounds.y + 3, null);
        else
            g.drawImage(pause, stopBounds.x, stopBounds.y, null);

        if(refreshBounds.contains(mouseX, mouseY))
            g.drawImage(refresh.getScaledInstance(refresh.getWidth() + 3, refresh.getHeight() + 3,
                    BufferedImage.SCALE_DEFAULT), refreshBounds.x + 3, refreshBounds.y + 3, null);
        else
            g.drawImage(refresh, refreshBounds.x, refreshBounds.y, null);

        if(musicBounds.contains(mouseX, mouseY))
            g.drawImage(music.getScaledInstance(music.getWidth() + 3, music.getHeight() + 3, BufferedImage.SCALE_DEFAULT)
                    , musicBounds.x + 3, musicBounds.y + 3, null);
        else
            g.drawImage(music, musicBounds.x, musicBounds.y, null);

        if(backToMenu.contains(mouseX, mouseY))
            g.drawImage(toMenu.getScaledInstance(toMenu.getWidth() + 3, toMenu.getHeight() + 3, BufferedImage.SCALE_DEFAULT)
                    , backToMenu.x + 3, backToMenu.y + 3, null);
        else
            g.drawImage(toMenu, backToMenu.x, backToMenu.y, null);



        if(gameOver)
        {
            saveCrystals();
            getClip().close();
            this.getFrame().setVisible(false);
            this.setVisible(false);

            int s = getScore();

            if (s>currentScore){
                saveScore(s-1);

                Record_window rec = new Record_window();
                rec.setLocationRelativeTo(null);
                rec.setVisible(true);
            }
            else {
                Lose_window lose = new Lose_window();
                lose.setLocationRelativeTo(null);
                lose.setVisible(true);
            }

        }
        g.setColor(Color.WHITE);

        g.setFont(new Font("Georgia", Font.BOLD, 20));

        g.drawString("SCORE", Window.WIDTH - 125, Window.HEIGHT/2);
        g.drawString(score+"", Window.WIDTH - 125, Window.HEIGHT/2 + 30);

        Graphics2D scoreSum = (Graphics2D)g;
        scoreSum.drawString("Score: " + score,315, 300);

        Graphics2D g2d = (Graphics2D)g;


        Graphics2D linesSum = (Graphics2D)g;
        linesSum.drawString(": " + lineQuantity,355, 350);


        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 0, 0, 248));

        Graphics2D lines = (Graphics2D)g;
        lines.drawImage(ImageLoader.loadImage("crystal.png"), 315, 320, 40,40, null);


        for(int i = 0; i <= boardHeight; i++)
        {
            g2d.drawLine(0, i*blockSize, boardWidth*blockSize, i*blockSize);
        }
        for(int j = 0; j <= boardWidth; j++)
        {
            g2d.drawLine(j*blockSize, 0, j*blockSize, boardHeight*30);
        }
    }

    public void setNextShape(){
        int index = (int)(Math.random()*shapes.length);
        nextShape = new Shape(shapes[index].getCoords(), shapes[index].getBlock(), this, shapes[index].getColor());
    }

    private void saveScore(int score) {
        File newFile = new File("D:/tetris_info/Score.txt");
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(newFile))) {
            writter.write(String.valueOf(score));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentShape(){
        currentShape = nextShape;
        setNextShape();

        for(int row = 0; row < currentShape.getCoords().length; row ++)
        {
            for(int col = 0; col < currentShape.getCoords()[0].length; col ++)
            {
                if(currentShape.getCoords()[row][col] != 0)
                {
                    if(board[currentShape.getY() + row][currentShape.getX() + col] != 0)
                        gameOver = true;
                }
            }
        }

    }




    public int[][] getBoard(){
        return board;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
            currentShape.rotateShape();
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            currentShape.setDeltaX(1);
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            currentShape.setDeltaX(-1);
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            currentShape.speedUp();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            currentShape.speedDown();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void startGame(){
        stopGame();
        setNextShape();
        setCurrentShape();
        gameOver = false;
        looper.start();
        playMusic();
        while (gameOver = false){
            if(!clip.isRunning()){
                clip.setFramePosition(0);
                clip.start();
            }
        }
    }

    public void stopGame(){
        score = 0;
        lineQuantity =0;

        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col ++)
            {
                board[row][col] = 0;
            }
        }
        looper.stop();
    }


    class GameLooper implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftClick = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftClick = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addScore(){
        score ++;
    }

    public void addLines(){
        lineQuantity++;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getLineQuantity() {
        return lineQuantity;
    }

    public void playMusic() {
        try {
            File soundFile = new File("D:/tetris_info/default_music.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            clip = AudioSystem.getClip();

            clip.open(ais);

            clip.setFramePosition(0);
            clip.start();

            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (IOException  exc) {
            exc.printStackTrace();
        } catch (UnsupportedAudioFileException exc) {
            exc.printStackTrace();
        } catch (LineUnavailableException exc) {
            exc.printStackTrace();
        }
    }

    public Clip getClip() {
        return clip;
    }

    private int getCrystals() {
        String cr = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:/tetris_info/HowManyCrystals.txt"))) {
            cr = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(cr);
    }

    private void saveCrystals() {
        int i = getCrystals();
        int a = getLineQuantity();
        int wr = i+a;
        File newFile = new File("D:/tetris_info/HowManyCrystals.txt");
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(newFile))) {
            writter.write(String.valueOf(wr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}