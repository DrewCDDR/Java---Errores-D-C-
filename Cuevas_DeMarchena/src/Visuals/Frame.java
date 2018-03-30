package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *@author Gabriel Cuevas
 * Codigo: 200073603.
 * @author Cristhyan De Marchena.
 * Codigo: 200082385.
 */
public class Frame extends javax.swing.JFrame{
    private final int WIDTH = 420, HEIGHT = 561, BORDER_WIDTH = 6, BORDER_HEIGHT = 29;
    private int e = 100;
    private String fname;
    private String[] lines;
    private java.io.File f;
    
    private javax.swing.text.StyledDocument doc;
    private javax.swing.text.Style status_style;
    private javax.swing.JPanel dialogs_panel, buttons_panel;
    private javax.swing.JLabel status_label, detect_label, correct_label;
    private javax.swing.JTextArea input_dialog, output_dialog;
    private javax.swing.JTextPane status_chat;
    private javax.swing.JButton detect_create, detect_read, correct_create, correct_read, open;
    private javax.swing.JFileChooser fc;
    
    
    /**
     * <title>Constructor.</title>
     * @throws HeadlessException 
     */
    public Frame() throws HeadlessException {
        setLayout(new java.awt.GridBagLayout());
        setSize(WIDTH +BORDER_WIDTH, HEIGHT +BORDER_HEIGHT);
        setResizable(false);
        setTitle("Errores (D & C)");
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        setIconImage(icon);
        getContentPane().setBackground(java.awt.Color.black);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocationRelativeTo(null);
        
        setGUI();
        
        setVisible(true);
    }
    
    public void setGUI(){
        // LAYOUT.
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        
        // BORDERS.
        javax.swing.border.Border border;
        border = javax.swing.BorderFactory.createLineBorder(java.awt.Color.white);
        
        // PANELS.
        dialogs_panel = new javax.swing.JPanel(new java.awt.GridLayout(3, 1, 15, 15));
        buttons_panel = new javax.swing.JPanel(new java.awt.GridLayout(3, 2, 15, 15));
        java.awt.Dimension d = new java.awt.Dimension(WIDTH, 135);
        buttons_panel.setPreferredSize(d);
        
        
        // LABELS.
        detect_label = new javax.swing.JLabel();
        detect_label.setSize(200, 30);
        detect_label.setLocation(15, HEIGHT -135);
        detect_label.setForeground(java.awt.Color.white);
        detect_label.setText("Para detección:");
        detect_label.setVisible(true);
        
        
        correct_label = new javax.swing.JLabel();
        correct_label.setSize(200, 30);
        correct_label.setLocation(WIDTH -175, HEIGHT -135);
        correct_label.setForeground(java.awt.Color.white);
        correct_label.setText("Para corrección:");
        correct_label.setVisible(true);
        
        // BUTTONS.
        detect_create = new javax.swing.JButton("Crear .BTP");
        detect_create.setFocusable(false);
        detect_create.setSize(120, 30);
        detect_create.setLocation(30, HEIGHT -90);
        detect_create.setForeground(java.awt.Color.white);
        detect_create.setBackground(java.awt.Color.black);
        detect_create.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   detectCreateActionPerformed(evt);
            }
        });
        
        detect_read = new javax.swing.JButton("Leer .BTP");
        detect_read.setFocusable(false);
        detect_read.setSize(120, 30);
        detect_read.setLocation(30, HEIGHT -45);
        detect_read.setForeground(java.awt.Color.white);
        detect_read.setBackground(java.awt.Color.black);
        detect_read.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   detectReadActionPerformed(evt);
            }
        });
        
        correct_create = new javax.swing.JButton("Crear .HAM");
        correct_create.setFocusable(false);
        correct_create.setSize(120, 30);
        correct_create.setLocation(WIDTH -150, HEIGHT -90);
        correct_create.setForeground(java.awt.Color.white);
        correct_create.setBackground(java.awt.Color.black);
        correct_create.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   correctCreateActionPerformed(evt);
            }
        });
        
        correct_read = new javax.swing.JButton("Leer .HAM");
        correct_read.setFocusable(false);
        correct_read.setSize(120, 30);
        correct_read.setLocation(WIDTH -150, HEIGHT -45);
        correct_read.setForeground(java.awt.Color.white);
        correct_read.setBackground(java.awt.Color.black);
        correct_read.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   correctReadActionPerformed(evt);
            }
        });
        
        // TEXT PANE.
        status_chat = new javax.swing.JTextPane();
        status_chat.setSize(360 , HEIGHT/4 -HEIGHT/16);
        status_chat.setLocation(30, 15);
        status_chat.setForeground(java.awt.Color.white);
        status_chat.setBackground(java.awt.Color.black);
        status_chat.setFont(new Font("Arial",Font.BOLD, 12));
        status_chat.setEditable(false);
        status_chat.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                border, javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        status_chat.setText("--- Esta es la ventana de estado ---");
//        add(status_chat);
        
        input_dialog = new javax.swing.JTextArea();
        input_dialog.setSize(360, HEIGHT/4 -HEIGHT/16);
        input_dialog.setLocation(30, 150);
        input_dialog.setForeground(java.awt.Color.white);
        input_dialog.setBackground(java.awt.Color.black);
        input_dialog.setFont(new Font("Arial",Font.BOLD, 12));
        input_dialog.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                border, javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        input_dialog.setText("-- Texto del archivo de entrada --");
        input_dialog.setEditable(false);
        input_dialog.setLineWrap(false);
        input_dialog.setWrapStyleWord(true);
//        add(input_dialog);
        
        output_dialog = new javax.swing.JTextArea();
        output_dialog.setSize(360, HEIGHT/4 -HEIGHT/16);
        output_dialog.setLocation(30, 285);
        output_dialog.setForeground(java.awt.Color.white);
        output_dialog.setBackground(java.awt.Color.black);
        output_dialog.setFont(new Font("Arial",Font.BOLD, 12));
        output_dialog.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                border, javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        output_dialog.setText("-- Texto del archivo de salida --");
        output_dialog.setEditable(false);
        output_dialog.setLineWrap(false);
        output_dialog.setWrapStyleWord(true);
//        add(output_dialog);
        
        // SCROLLS
        javax.swing.JScrollPane statusChatSlider = new javax.swing.JScrollPane(status_chat);
        statusChatSlider.setBounds(30, 15, 360, HEIGHT/4 -HEIGHT/16);
        statusChatSlider.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        statusChatSlider.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(statusChatSlider);
        
        javax.swing.JScrollPane inputDialogSlider = new javax.swing.JScrollPane(input_dialog);
        statusChatSlider.setBounds(30, 150, 360, HEIGHT/4 -HEIGHT/16);
        statusChatSlider.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        statusChatSlider.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(inputDialogSlider);
        
        javax.swing.JScrollPane outputDialogSlider = new javax.swing.JScrollPane(output_dialog);
        statusChatSlider.setBounds(30, 285, 360, HEIGHT/4 -HEIGHT/16);
        statusChatSlider.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        statusChatSlider.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(outputDialogSlider);
        
        // DOCS AND STYLES.
        doc = status_chat.getStyledDocument();
        status_style = status_chat.addStyle("I'm a Style", null);
        
        // ADDING TO PANELS:
            // PANEL 4 BUTTONS:
        buttons_panel.add(detect_label);
        buttons_panel.add(correct_label);
        buttons_panel.add(detect_create);
        buttons_panel.add(correct_create);
        buttons_panel.add(detect_read);
        buttons_panel.add(correct_read);
        buttons_panel.setBackground(Color.black);
            
            // PANEL 4 DIALOGS.
        dialogs_panel.add(statusChatSlider);
        dialogs_panel.add(inputDialogSlider);
        dialogs_panel.add(outputDialogSlider);
        dialogs_panel.setBackground(Color.black);
        
            // MAIN
        gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
	gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
	gbc.ipady = 300;                                                //HEIGHT
        gbc.ipadx = 200;
	gbc.weightx = 0;   //request any extra vertical space
	gbc.anchor = java.awt.GridBagConstraints.PAGE_START;          //location
	gbc.insets = new java.awt.Insets(10,10,0,10);             //top paddings
	gbc.gridx = 0;                                   //aligned with button 2
	gbc.gridwidth = 2;                                      //2 columns wide
	gbc.gridy = 0;                                               //third row
	getContentPane().add(dialogs_panel, gbc);
        
        gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
	gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
	gbc.ipady = 25;                                                //HEIGHT
	gbc.weighty = 1.0;   //request any extra vertical space
	gbc.anchor = java.awt.GridBagConstraints.PAGE_END;            //location
	gbc.insets = new java.awt.Insets(30,10,10,10);            //top paddings
	gbc.gridx = 0;                                   //aligned with button 2
	gbc.gridwidth = 1;                                      //2 columns wide
	gbc.gridy = 0;                                               //third row
        getContentPane().add(buttons_panel, gbc);
    }
    
    public char[] stringIntoChars(String line){
        char[] letters = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            letters[i] = line.charAt(i);
        }
        return letters;
    }
    
    public boolean[] checkCharsAlphabet4txt(char[] letters){
        boolean [] checkers = new boolean[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if(Character.isLetter(letters[i]) || letters[i] == ' ' ||
                    letters[i] == '.' || letters[i] == ',' || letters[i] == ';' 
                    || letters[i] == ':'){
                checkers[i] = true;
            }else{
                checkers[i] = false;
            }
        }
        return checkers;
    }
    
    public boolean[] checkCharsAlphabet4NoTxt(char[] letters){
        boolean [] checkers = new boolean[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] == '0' || letters[i] == '1'){
                checkers[i] = true;
            }else{
                checkers[i] = false;
            }
        }
        return checkers;
    }
    
    public boolean checkBooleanArrayIsTrue(boolean[] checkers){
        boolean check = true;
        
        for (int i = 0; i < checkers.length; i++) {
            if (!checkers[i]) {
                check = false;
            }
        }
        return check;
    }
    
    public void readFile(java.io.File f){
        boolean[] linesAlphabet;
        int numLines = 0;
        String temp;
        
        if(f.getName().contains(".txt")){
            try{
                java.util.Scanner s = new java.util.Scanner(f);
                while (s.hasNextLine()) {                
                    temp = s.nextLine();
                    numLines++;
                }

                if(numLines == 0){
                    // No hay lineas.
                    e = 1;
                }else{
                    linesAlphabet = new boolean[numLines];
                    lines = new String[numLines];

                    s = new java.util.Scanner(f);

                    for (int i = 0; i < numLines; i++) {
                        lines[i] = s.nextLine();
                        linesAlphabet[i] = checkBooleanArrayIsTrue(checkCharsAlphabet4txt(stringIntoChars(lines[i])));
                    }

                    if (checkBooleanArrayIsTrue(linesAlphabet)) {
                        // Todas las lineas son validas.
                        e = 0;
                    }else{
                        // Por lo menos hay una linea que tiene caracteres no vaildos.
                        e = 2;
                    }
                }

            }catch(Exception er){
                append("\n-- Archivo no encontrado.", java.awt.Color.red);
            }
        }else{
            try{
                java.util.Scanner s = new java.util.Scanner(f);
                while (s.hasNextLine()) {                
                    temp = s.nextLine();
                    numLines++;
                }

                if(numLines == 0){
                    // No hay lineas.
                    e = 1;
                }else{
                    linesAlphabet = new boolean[numLines];
                    lines = new String[numLines];

                    s = new java.util.Scanner(f);

                    for (int i = 0; i < numLines; i++) {
                        lines[i] = s.nextLine();
                        linesAlphabet[i] = checkBooleanArrayIsTrue(checkCharsAlphabet4NoTxt(stringIntoChars(lines[i])));
                    }

                    if (checkBooleanArrayIsTrue(linesAlphabet)) {
                        // Todas las lineas son validas.
                        e = 0;
                    }else{
                        // Por lo menos hay una linea que tiene caracteres no vaildos.
                        e = 2;
                    }
                }

            }catch(Exception er){
                append("\n-- Archivo no encontrado.", java.awt.Color.red);
            }
        }
    }
    
    public void setErrors(int e){
        switch(e){
            case 0:
                append("\n- El archivo cumple las condiciones estabelcidas.", java.awt.Color.white);
                break;
            case 1:
                append("\n-- El archivo esta vacío o no tiene lineas.", java.awt.Color.red);
                break;
            case 2:
                append( "\n-- Una o más de las lineas no cumple(n) con el alfabeto establecido.", java.awt.Color.red);
                break;
        }
    }
    
    public void openFile(String ext){
        fc = new javax.swing.JFileChooser();
        int fcReturnVal = fc.showOpenDialog(this);
        
        if (fcReturnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            f = fc.getSelectedFile();
        }else{
            append("\n-- No se selecciono ningun archivo.", java.awt.Color.white);
            f = new java.io.File("Files/Salida" +ext);
        }
        append("\n-- Abriendo: " +f.getName().toString(), java.awt.Color.green);
        readFile(f);
        setErrors(e);
    }
    
    public boolean checkStringArrLength(String[] lines, int length){
        boolean[] checkers = new boolean[lines.length];
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 0 && lines[i].length() <= length) {
                checkers[i] = true;
            }else{
                checkers[i] = false;
            }
        }
        return checkBooleanArrayIsTrue(checkers);
    }
    
    public String dec2bin(int dec){
        int exp = 0;
        int base = 2;
        String bin = "";
        
        while (dec >= Math.pow(base, exp)) {            
            exp++;
        }
        exp--;
        
        int temp = dec;
        for (int i = exp; i >= 0; i--) {
            if (temp >= Math.pow(base, i)) {
                temp -= Math.pow(base, i);
                bin = bin +"1";
            }else{
                bin = bin +"0";
            }
        }
        
        if (bin.length() < 8) {
            switch ((8 -bin.length())) {
                case 1:
                    bin = "0" +bin;
                    break;
                case 2:
                    bin = "00" +bin;
                    break;
                case 3:
                    bin = "000" +bin;
                    break;
                case 4:
                    bin = "0000" +bin;
                    break;
                case 5:
                    bin = "00000" +bin;
                    break;
                case 6:
                    bin = "000000" +bin;
                    break;
                case 7:
                    bin = "0000000" +bin;
                    break;
            }
        }
        
        return bin;
    }
    
    public String string2ascii2bin(String line){
        char[] letters = stringIntoChars(line);
        int ascii;
        String max128bit = "";
        for (int i = 0; i < letters.length; i++) {
            ascii = (int) letters[i];
            max128bit = max128bit +dec2bin(ascii);
        }
        return max128bit;
    }
    
    public String addParityBit(String line){
        char[] chars = stringIntoChars(line);
        int times = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                times++;
            }
        }
        
        if (times%2 == 0) {
            line = line +"0";
        }else{
            line = line +"1";
        }
        
        return line;
    }
    
    public boolean isParityBitCorrect(String line){
        char[] chars = stringIntoChars(line);
        int times = 0;
        for (int i = 0; i < chars.length -1; i++) {
            if (chars[i] == '1') {
                times++;
            }
        }
        
        if (times%2 == 0) {
            switch (chars[chars.length -1]) {
                case '1':
                    return false;
                case '0':
                    return true;
                default:
                    return false;
            }
        }else{
            switch (chars[chars.length -1]) {
                case '1':
                    return true;
                case '0':
                    return false;
                default:
                    return false;
            }
        }
    }
    
    public String bin2ascii2string(String bin){
        String line = "";
        int begin = 0, end = 7;
        int ascii = 0;
        int index = 0;
        boolean[] powers = new boolean[8];
        if ((bin.length())%8 == 0) {
            for (int i = 0; i < (bin.length())/8; i++) {
                index = 0;
                for (int j = begin; j <= end; j++) {
                    if (bin.charAt(j) == '1') {
                        powers[8 -(index +1)] = true;
                    }else if(bin.charAt(j) == '0'){
                        powers[8 -(index +1)] = false;
                    }
                    index++;
                }
                
                ascii = 0;
                for (int j = 0; j < powers.length; j++) {
                    if (powers[j]) {
                        ascii = ascii +(int)Math.pow(2, j);
                    }
                }
                
                line = line +Character.toString((char) ascii);
                begin += 8;
                end += 8;
            }
        }else{
            append("\n-- El número binario no puede ser convertido a ASCII", java.awt.Color.red);
        }
        return line;
    }
    
    public int numberOfParityBitsForCodeword(int k){
        int m = 0;
        while(Math.pow(2, m) < (k +m +1)){
            m++;
        }
        return m;
    }
    
    public boolean[] binaryToBoolean(String binary){
        char[] charsOfDataword = stringIntoChars(binary);
        boolean[] boolDataword = new boolean[charsOfDataword.length];
        for (int i = 0; i < charsOfDataword.length; i++) {
            if (charsOfDataword[i] == '1') {
                boolDataword[i] = true;
            }else if(charsOfDataword[i] == '0'){
                boolDataword[i] = false;
            }
            
        }
        return invertArrElements(boolDataword);
    }
    
    public boolean[] invertArrElements(boolean[] bool){
        boolean temp;
        for (int i = 0; i < bool.length/2; i++) {
            temp = bool[i];
            bool[i] = bool[bool.length -(i +1)];
            bool[bool.length -(i +1)] = temp;
        }
        return bool;
    }
    
    public java.util.ArrayList eachParityBitFunc(int n, int k){
        int numbers[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = i +1;
        }
        
        for (int l = 0; l < k; l++) {
            numbers[(int)Math.pow(2, l) -1] = 0;
        }
        
        String[] positions4xor = new String[k];
        for (int i = 0; i < k; i++) {
            positions4xor[i] = "";
        }
        
        for(int exp = k -1; exp >= 0; exp--) {
            for (int i = n -1; i >= 0; i--) {
                if (numbers[i] >= (int)Math.pow(2, exp)) {
                    positions4xor[exp] = positions4xor[exp] +" " +(i +1);
                    numbers[i] = numbers[i] -(int)Math.pow(2, exp);
                }
            }
        }
        
        java.util.ArrayList<int[]> positions = new java.util.ArrayList<>();
        int[] temp = {};
        String[] temp2 = {};
        for (String positions4xor1 : positions4xor) {
            temp2 = positions4xor1.split(" ");
            temp = new int[temp2.length -1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(temp2[j +1]);
            }
            positions.add(temp);
        }
        
        return positions;
    }
    
    public int[] substractingValuesOfEachPos(int n, int k){
        int temp = k -1;
        int[] subs = new int[n];
        for (int i = n -1; i >= 0; i--) {
            if ((i +1) > Math.pow(2, temp)) {
                subs[i] = temp +1;
            }else{
                subs[i] = 0;
                temp--;
            }
        }
        return subs;
    }
    
    public boolean[] codewordAsBoolean(int n, boolean[] dataword){
        boolean r;
        boolean[] codeword = new boolean[n];
        boolean[] xor;
        int k = n -dataword.length;
        int marked = 0;
        int[] subs = substractingValuesOfEachPos(n, k);
        java.util.ArrayList<int[]> bitPos = eachParityBitFunc(n, k);
        
        for (int i = 0; i < n; i++) {
            if ((i +1) == Math.pow(2, marked)) {
                //parity bit.
                xor = new boolean[bitPos.get(marked).length];
                for (int j = 0; j < bitPos.get(marked).length; j++) {
                    xor[j] = dataword[bitPos.get(marked)[j] -subs[bitPos.get(marked)[j] -1] -1];
                }
                
                r = xor[0] != xor[1];
                
                for (int j = 2; j < xor.length; j++) {
                    r = r != xor[1];
                }
                codeword[i] = r;
                marked++;
            }else{
                //data bit
                codeword[i] = dataword[i -marked]; 
            }
        }
        
        return invertArrElements(codeword);
    }
    
    public int numberOfParityBitsFromCodeword(int n){
        int k = 0;
        while (n > Math.pow(2, k)) {            
            k++;
        }
        return k;
    }
    
    public boolean[] checkedParityBitsOfCodeword(boolean[] codeword){
        int n = codeword.length;
        int k = numberOfParityBitsFromCodeword(n);
        boolean r;
        boolean[] xor;
        boolean[] checkedParityBits = new boolean[k];
        java.util.ArrayList<int[]> bitPos = eachParityBitFunc(n, k);
        
        for (int i = 0; i < k; i++) {
            xor = new boolean[bitPos.get(i).length];
            for (int j = 0; j < bitPos.get(i).length; j++) {
                xor[j] = codeword[bitPos.get(i)[j] -1];
            }
            r = xor[0] != xor[1];
            for (int j = 2; j < xor.length; j++) {
                r = r != xor[1];
            }
            r = r != codeword[(int)Math.pow(2, i) -1];
            checkedParityBits[i] = r;
        }
        
        return invertArrElements(checkedParityBits);
    }
    
    public boolean[] codewordToDataword(boolean[] codeword){
        int n = codeword.length;
        int k = numberOfParityBitsFromCodeword(n);
        boolean[] dataword = new boolean[n -k];
        int index = 0;
        for (int i = n -1; i >= 0; i--) {
            if (! ((i+1) == (int)Math.pow(2, (k-1))) ) {
                dataword[index] = codeword[i];
                index++;
            }else{
                k--;
            }
        }
        
        return dataword;
    }
    
    public int binaryToInt(boolean[] binary){
        int dec = 0;
        boolean[] temp = invertArrElements(binary);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]) {
                dec = dec +(int)Math.pow(2, i);
            }
        }
        return dec;
    }
    
    public String boolToString(boolean[] bool){
        String s = "";
        for (int i = 0; i < bool.length; i++) {
            if (bool[i]) {
                s = s +"1";
            }else{
                s = s +"0";
            }
        }
        return s;
    }
            
    public void printInputLines(){
        input_dialog.append("\n");
        for (int i = 0; i < lines.length; i++) {
            input_dialog.append("\n" +i +": " +lines[i]);
        }
    }
    
    // FUNCIONES PARA LOS BOTONES.
    public void detectCreateActionPerformed(java.awt.event.ActionEvent evt){
        append("\n-- Se leera un .txt para crear su .btp", java.awt.Color.green);
        append("\n-- Se esta seleccionando el .txt", java.awt.Color.white);
        openFile(".txt");
        append("\n-- Creando el .btp", java.awt.Color.green);
        java.io.PrintWriter w;
        try{
            fname = f.getName().split("\\.")[0] +".btp";
            String path = f.getParent() +"\\" +fname;
            w = new java.io.PrintWriter(path, "UTF-8");
        }catch(Exception e){
            w = null;
        }
        input_dialog.append("\n\n# Archivo: " +f.getName().split("\\.")[0]);
        output_dialog.append("\n\n# Archivo : " +f.getName().split("\\.")[0]);
        printInputLines();
        append("\n- Se esta convirtiendo la informacion a binario a partir de sus codigos ascii", java.awt.Color.white);
        String binaryForm, parityForm;
        if (checkStringArrLength(lines, 16)) {
            output_dialog.append("\n");
            for (int i = 0; i < lines.length; i++) {
                binaryForm = string2ascii2bin(lines[i]);
                append("\n- Añadiendo bit de paridad para la linea " +(i +1), java.awt.Color.white);
                parityForm = addParityBit(binaryForm);
                if (i == lines.length -1) {
                    w.print(parityForm);
                }else{
                    w.print(parityForm +"\n");
                }
                output_dialog.append("\n" +i +": " +parityForm);
            }
            w.close();
            append("\n-- Se ha creado el archivo .btp", java.awt.Color.green);
        }else{
            append("\n-- Una o más lineas tiene(n) una longitud superior a 16.", java.awt.Color.red);
        }
    }
    
    public void detectReadActionPerformed(java.awt.event.ActionEvent evt){
        boolean error = false;
        append("\n-- Se leera un .btp para crear su .txt en caso de estar correcto.", java.awt.Color.green);
        append("\n-- Se esta seleccionando el .btp", java.awt.Color.white);
        openFile(".btp");
        
        append("\n- Detectando si hay o no hay error.", java.awt.Color.white);
        java.io.PrintWriter w;
        
        if (checkStringArrLength(lines, 129)) {
            boolean[] parityIsCorrect = new boolean[lines.length];
            for (int i = 0; i < lines.length; i++) {
                if (isParityBitCorrect(lines[i])) {
                    parityIsCorrect[i] = true;
                }else{
                    parityIsCorrect[i] = false;
                }
            }
            
            if (checkBooleanArrayIsTrue(parityIsCorrect)) {
                error = false;
            }else{
                error = true;
            }
            
            input_dialog.append("\n\n# Archivo: " +f.getName().split("\\.")[0]);
            output_dialog.append("\n\n# Archivo : " +f.getName().split("\\.")[0]);;
            printInputLines();
            
            if (!error) {
                append("\n-- Creando el .txt traducido", java.awt.Color.green);
                try{
                    String fname = f.getName().split("\\.")[0] +"_traducido.txt";
                    String path = f.getParent() +"\\" +fname;
                    w = new java.io.PrintWriter(path, "UTF-8");
                }catch(Exception e){
                    w = null;
                }
                append("\n-- Traduciendo desde el .btp", java.awt.Color.white);
                String decoded = "";
                output_dialog.append("\n");
                String line = "";
                for (int i = 0; i < lines.length; i++) {
                    line = lines[i].substring(0, lines[i].length() - 1);
                    decoded = bin2ascii2string(line);
                    if (!checkBooleanArrayIsTrue(checkCharsAlphabet4txt(stringIntoChars(decoded)))) {
                        append("\n- La linea " +(i +1) +" no cumple con el alfabeto.", java.awt.Color.red);
                    }
                    if (i == lines.length -1) {
                        w.print(decoded);
                    }else{
                        w.print(decoded +"\n");
                    }
                    output_dialog.append("\n" +i +": " +decoded);
                }
                w.close();
                append("\n-- Se ha terminado de traducir en el .txt traducido.", java.awt.Color.green);
            }else{
                append("\n-- Se ha detectado que una o más lineas tiene(n) error.", java.awt.Color.red);
            }
        }else{
            append("\n-- Una o más lineas tiene(n) una longitud superior a 129.", java.awt.Color.red);
        }
    }
    
    public void correctCreateActionPerformed(java.awt.event.ActionEvent evt){
        append("\n-- Se leera un .txt para crear su .ham", java.awt.Color.green);
        append("\n-- Se esta seleccionando el .txt", java.awt.Color.white);
        openFile(".txt");
        append("\n-- Creando el .ham", java.awt.Color.green);
        java.io.PrintWriter w;
        try{
            String fname = f.getName().split("\\.")[0] +".ham";
            String path = f.getParent() +"\\" +fname;
            w = new java.io.PrintWriter(path, "UTF-8");
        }catch(Exception e){
            w = null;
        }
        
        input_dialog.append("\n\n# Archivo: " +f.getName().split("\\.")[0]);
        output_dialog.append("\n\n# Archivo : " +f.getName().split("\\.")[0]);
        printInputLines();
        append("\n- Se esta convirtiendo la informacion a binario a partir de sus codigos ascii", java.awt.Color.white);
        String dataword, codeword;
        if (checkStringArrLength(lines, 2)) {
            output_dialog.append("\n");
            int n;
            for (int i = 0; i < lines.length; i++) {
                dataword = string2ascii2bin(lines[i]);
                n = numberOfParityBitsForCodeword(dataword.length()) +dataword.length();
                append("\n- Creando palabra de codigo para la linea: " +(i +1), java.awt.Color.white);
                codeword = boolToString(codewordAsBoolean(n, binaryToBoolean(dataword)));
                if (i == lines.length -1) {
                    w.print(codeword);
                }else{
                    w.print(codeword +"\n");
                }
                output_dialog.append("\n" +i +": " +codeword);
            }
            w.close();
            append("\n-- Se ha creado el archivo .ham", java.awt.Color.green);
        }else{
            append("\n-- Una o más lineas tiene(n) una longitud superior a 2.", java.awt.Color.red);
        }
    }
    
    public void correctReadActionPerformed(java.awt.event.ActionEvent evt){
        append("\n-- Se leera un .ham para crear su .txt en caso de estar correcto.", java.awt.Color.green);
        append("\n-- Se esta seleccionando el .ham", java.awt.Color.white);
        openFile(".ham");
        output_dialog.append("\n");
        append("\n- Detectando si hay o no hay error.", java.awt.Color.white);
        java.io.PrintWriter w;
        
        append("\n-- Creando el .txt traducido", java.awt.Color.green);
        try{
            String fname = f.getName().split("\\.")[0] +"_traducido.txt";
            String path = f.getParent() +"\\" +fname;
            w = new java.io.PrintWriter(path, "UTF-8");
        }catch(Exception e){
            w = null;
        }
        
        input_dialog.append("\n\n# Archivo: " +f.getName().split("\\.")[0]);
        output_dialog.append("\n\n# Archivo : " +f.getName().split("\\.")[0]);
        printInputLines();
        
        append("\n-- Traduciendo desde el .ham", java.awt.Color.white);
        boolean[] invCodeword;
        boolean[] checkedParityBits;
        int er;
        String dataword = "", data = "";
        if (checkStringArrLength(lines, 21)) {
            for (int i = 0; i < lines.length; i++) {
                invCodeword = binaryToBoolean(lines[i]);
                checkedParityBits = checkedParityBitsOfCodeword(invCodeword);
                er = binaryToInt(checkedParityBits);
                if (er != 0) {
                    append("\n- Se detecto error en el bit " +er +" en la linea #" +(i +1), Color.red);
                    invCodeword[er -1] = !invCodeword[er -1];
                    append("\n- Error corregido en la linea #" +(i +1), Color.green);
                }else{
                    append("\n- No se detecto error en la linea #" +(i +1), Color.green);
                }
                append("\n- Generando palabra de datos de la linea #" +(i +1), Color.white);
                dataword = boolToString(codewordToDataword(invCodeword));
                data = bin2ascii2string(dataword);
                if (!checkBooleanArrayIsTrue(checkCharsAlphabet4txt(stringIntoChars(data)))) {
                    append("\n- La linea " +(i +1) +" no cumple con el alfabeto.", java.awt.Color.red);
                }
                if (i == lines.length -1) {
                    w.print(data);
                }else{
                    w.print(data +"\n");
                }
                output_dialog.append("\n" +i +": "  +data);
            }
            
            w.close();
            append("\n-- Se ha terminado de traducir en el .txt traducido.", java.awt.Color.green);
        }else{
            append("\n-- Una o más lineas tiene(n) una longitud superior a 21.", java.awt.Color.red);
        }
    }
    
    // FUNCION PARA AGREGAR TEXTO AL JTEXTPANE (status_chat)
    private void append(String msg, java.awt.Color c)
    {
        javax.swing.text.StyleConstants.setForeground(status_style, c);

        try { 
            doc.insertString(doc.getLength(), msg, status_style); 
        }catch (javax.swing.text.BadLocationException e){
            
        }
        status_chat.scrollRectToVisible(new java.awt.Rectangle(0,status_chat.getHeight() +10,1,1));
    }
}
