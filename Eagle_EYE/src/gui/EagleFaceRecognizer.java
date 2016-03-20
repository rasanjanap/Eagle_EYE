/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import static org.bytedeco.javacpp.opencv_contrib.*;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;

/**
 *
 * @author Kavinda Rasanjana
 */
public class EagleFaceRecognizer {
    int predictedLabel = -1;

    public int FRecognizer(String path) {

        String trainingDir = "C:\\Users\\Kavinda\\Documents\\NetBeansProjects\\Eagle_EYE\\trainingImages";

        Mat testImage = imread(path, CV_LOAD_IMAGE_GRAYSCALE);

        File root = new File(trainingDir);

        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
            }
        };

        File[] imageFiles = root.listFiles(imgFilter);

        MatVector images = new MatVector(imageFiles.length);

        Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
        IntBuffer labelsBuf = labels.getIntBuffer();

        int counter = 0;

        for (File image : imageFiles) {
            Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);

            int label = Integer.parseInt(image.getName().split("\\-")[0]);

            images.put(counter, img);

            labelsBuf.put(counter, label);

            counter++;
        }

        // FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
        FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
        

        faceRecognizer.train(images, labels);
        
        predictedLabel = faceRecognizer.predict(testImage);
        System.out.println("Predicted label: " + predictedLabel);
        return predictedLabel;
         
         
         
    }
}
