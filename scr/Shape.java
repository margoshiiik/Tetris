import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Shape {

    private int color;

    private int x, y;

    private long time, lastTime;

    private int normal;

    private int fast = 50;

    private int delay;

    private BufferedImage block;

    private int[][] coords;

    private int[][] reference;

    private int deltaX;

    private Game_window game_window;//

    private boolean collision = false, moveX = false;

    public Shape(int[][] coords, BufferedImage block, Game_window game_window, int color){
        this.coords = coords;
        this.block = block;
        this.game_window = game_window;
        this.color = color;
        deltaX = 0;
        x = 4;
        y = 0;

        int speed = getCurrentSpeed();
        if(speed == 1) normal = 1000;
        else if (speed == 2) normal = 600;
        else normal = 100;

        delay = normal;
        time = 0;
        lastTime = System.currentTimeMillis();
        reference = new int[coords.length][coords[0].length];

        System.arraycopy(coords, 0, reference, 0, coords.length);

    }


    public void update(){
        moveX = true;
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(collision)
        {
            for(int row = 0; row < coords.length; row ++)
            {
                for(int col = 0; col < coords[0].length; col ++)
                {
                    if(coords[row][col] != 0)
                        game_window.getBoard()[y + row][x + col] = color;
                }
            }
            checkLine();
            game_window.addScore();
            game_window.setCurrentShape();
        }

        if(!(x + deltaX + coords[0].length > 10) && !(x + deltaX < 0))
        {

            for(int row = 0; row < coords.length; row++)
            {
                for(int col = 0; col < coords[row].length; col ++)
                {
                    if(coords[row][col] != 0)
                    {
                        if(game_window.getBoard()[y + row][x + deltaX + col] != 0)
                        {
                            moveX = false;

                        }

                    }
                }
            }

            if(moveX)
                x += deltaX;

        }

        if(!(y + 1 + coords.length > 20))
        {

            for(int row = 0; row < coords.length; row++)
            {
                for(int col = 0; col < coords[row].length; col ++)
                {
                    if(coords[row][col] != 0)
                    {

                        if(game_window.getBoard()[y + 1 + row][x +  col] != 0)
                        {
                            collision = true;
                        }
                    }
                }
            }
            if(time > delay)
            {
                y++;
                time = 0;
            }
        }else{
            collision = true;
        }

        deltaX = 0;
    }

    public void render(Graphics g){

        for(int row = 0; row < coords.length; row ++)
        {
            for(int col = 0; col < coords[0].length; col ++)
            {
                if(coords[row][col] != 0)
                {
                    g.drawImage(block, col*30 + x*30, row*30 + y*30, null);
                }
            }
        }

    }

    private void checkLine(){
        int size = game_window.getBoard().length - 1;

        for(int i = game_window.getBoard().length - 1; i > 0; i--)
        {
            int count = 0;
            for(int j = 0; j < game_window.getBoard()[0].length; j++)
            {
                if(game_window.getBoard()[i][j] != 0) {
                    count++;
                }

                else {
                    game_window.getBoard()[size][j] = game_window.getBoard()[i][j];

                }

                if(count == 10) game_window.addLines();
            }
            if(count < game_window.getBoard()[0].length) {
                size--;
            }
        }
    }

    public void rotateShape()
    {

        int[][] rotatedShape = null;

        rotatedShape = transposeMatrix(coords);

        rotatedShape = reverseRows(rotatedShape);

        if((x + rotatedShape[0].length > 10) || (y + rotatedShape.length > 20))
        {
            return;
        }

        for(int row = 0; row < rotatedShape.length; row++)
        {
            for(int col = 0; col < rotatedShape[row].length; col ++)
            {
                if(rotatedShape[row][col] != 0)
                {
                    if(game_window.getBoard()[y + row][x + col] != 0)
                    {
                        return;
                    }
                }
            }
        }
        coords = rotatedShape;
    }


    private int[][] transposeMatrix(int[][] matrix){
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                temp[j][i] = matrix[i][j];
        return temp;
    }



    private int[][] reverseRows(int[][] matrix){

        int middle = matrix.length/2;


        for(int i = 0; i < middle; i++)
        {
            int[] temp = matrix[i];

            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }

        return matrix;

    }


    public int getColor(){
        return color;
    }

    public void setDeltaX(int deltaX){
        this.deltaX = deltaX;
    }

    public void speedUp(){
        delay = fast;
    }

    public void speedDown(){
        int speed = getCurrentSpeed();
        if(speed == 1) normal = 100;
        else if (speed == 2) normal = 600;
        else normal = 1000;
        delay = normal;
    }

    public BufferedImage getBlock(){
        return block;
    }

    public int[][] getCoords(){
        return coords;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCurrentSpeed() {
        String speed = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:/tetris_info/Current speed.txt"))) {
            speed = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(speed);
    }
}