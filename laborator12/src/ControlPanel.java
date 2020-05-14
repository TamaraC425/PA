import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel  extends JPanel {
    private final MainFrame frame;
    private final JLabel classLabel=new JLabel("Class name");
    private final JTextField classField=new JTextField(40);
    private final JLabel label=new JLabel("Text");
    private final JTextField jTextField=new JTextField(10);
    private final JButton button=new JButton("Add component");
    private final JButton saveButton=new JButton("Save");
    private final JButton loadButton=new JButton("Load");
    private  JFileChooser file;

    public ControlPanel(MainFrame mainFrame) {
        this.frame=mainFrame;
        file=new JFileChooser();
        file.setCurrentDirectory(new File("."));
        init();

    }
   private void init()
    {
        add(classLabel);
        add(classField);
        add(label);
        add(jTextField);
        button.addActionListener(e ->{
            JComponent component=createComponent(classField.getText());
            if(component!=null)
            {
                setTextComponent(component,jTextField.getText());
                frame.designPanel.addComponent(component);
            }
        });
        add(button);
        saveButton.addActionListener(EventHandler.create(ActionListener.class,this,"save"));
        loadButton.addActionListener(EventHandler.create(ActionListener.class,this,"load"));
        add(saveButton);
        add(loadButton);
    }
    private JComponent createComponent(String className){
        try {
            Class classSwing = Class.forName(className);
            JComponent jcomponent=(JComponent)classSwing.getDeclaredConstructor().newInstance();
            return jcomponent;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void setTextComponent(JComponent component,String text)
    {
        Class classSwing=component.getClass();
        Method method= null;
        try {
            method = classSwing.getMethod("setText",String.class);
            method.invoke(component,text);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void save()
    {
        if(file.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            try {
                File xmlFile=file.getSelectedFile();
                XMLEncoder xmlEncoder= null;
                xmlEncoder = new XMLEncoder(new FileOutputStream(xmlFile));
                xmlEncoder.writeObject(this.frame);
                xmlEncoder.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    public void load()
    {

        if(file.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            try {
                File file1 = file.getSelectedFile();
                XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(file1));
                xmlDecoder.readObject();
                xmlDecoder.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }


}
