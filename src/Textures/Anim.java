package Textures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;

import com.sun.opengl.util.*;
import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

public class Anim extends JFrame {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i%4);
//        }
//        new Anim(new AnimGLEventListener3());
        new Anim();
    }


//    public Anim(AnimListener aListener) {
    public Anim() {
        GLCanvas glcanvas;
        Animator animator;
        
        AnimListener listener = new AnimGLEventListener3();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(30);
        animator.add(glcanvas);
        animator.start();

        setTitle("Connet4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
        
        
    }
}
