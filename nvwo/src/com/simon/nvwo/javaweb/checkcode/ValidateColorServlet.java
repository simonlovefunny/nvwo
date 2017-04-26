package com.simon.nvwo.javaweb.checkcode;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class ValidateColorServlet
 */
@WebServlet("/ValidateColorServlet")
public class ValidateColorServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    static final char[] dictionary = {
            '2','3','4','5','6','7','8','9'
            ,'a','b','c','d','e','f','g','h','i','j'
            ,'k','m','n','p','q','r','s','t'
            ,'u','v','w','x','y','z'
            ,'A','B','C','D','E','F','G','H','J'
            ,'K','L','M','N','P','Q','R','S','T'
            ,'U','V','W','X','Y','Z'
            /*'1','l','0','O','o','#','@','$','%','&','(',')','|','/','*'//��ʱ���������ַ�(����������1,0����ĸ��l,o,O)
            ,'^','!','~','\\'*/
            };
    static Random random = new Random();
     
    /**
     * ����n[4,4+]�������
     * @param n
     * @return
     */
    static String getRandomString(int n){
        StringBuffer buffer = new StringBuffer();
        if (n < 4) {
            n = 4;
        }
        for (int i = 0; i < n; i++) {
            buffer.append(dictionary[random.nextInt(dictionary.length)]);
        }
        return buffer.toString();
    }
     
    /**
     * �����ɫ
     * @return
     */
    static Color getRandomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
     
    /**
     * ��ɫ��ɫ
     * @param c
     * @return
     */
    static Color getReverseColor(Color c){
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
         
        String randomString = getRandomString(6);
         //�����ַ���
        request.getSession(true).setAttribute("CHECK_CODE_KEY", randomString);
         
        int width = 100; //��֤��ͼƬ���
        int height = 30; //��֤��ͼƬ�߶�
         
        Color color = getRandomColor();
         
        Color reverse = getReverseColor(color);
         
        //����һ����ͼ
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     
        //��ͼ����
        Graphics2D g = bi.createGraphics();
         
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
         
        //�������100��������
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
         
        ServletOutputStream out = response.getOutputStream();
         
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
         
        encoder.encode(bi);
         
        out.flush();
         
        out.close();
    }

}
