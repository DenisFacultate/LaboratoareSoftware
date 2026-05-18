package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fisierInput = "laborator8_input.xlsx";

        System.out.println("--- Rezolvare 8.5.1: Citire si afisare ---");
        citireSiAfisare(fisierInput);

        System.out.println("\n--- Rezolvare 8.5.2: Copiere si calcul medie in Java ---");
        calculeazaMedieSiExporta(fisierInput, "laborator8_output2.xlsx");

        System.out.println("\n--- Rezolvare 8.5.3: Copiere si inserare formula Excel ---");
        insereazaFormulaSiExporta(fisierInput, "laborator8_output3.xlsx");
    }

    public static void citireSiAfisare(String inputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        default:
                            System.out.print(" \t\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }

    public static void calculeazaMedieSiExporta(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Medii Calculate");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                double suma = 0;
                int countNote = 0;

                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());

                    if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    } else if (inputCell.getCellType() == CellType.NUMERIC) {
                        double valoare = inputCell.getNumericCellValue();
                        outputCell.setCellValue(valoare);

                        if (inputCell.getColumnIndex() >= 3 && inputCell.getColumnIndex() <= 5) {
                            suma += valoare;
                            countNote++;
                        }
                    }
                }

                if (countNote > 0 && inputRow.getRowNum() > 0) {
                    Cell averageCell = outputRow.createCell(6);
                    averageCell.setCellValue(suma / countNote);
                } else if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(6).setCellValue("Medie Calculata");
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                outputWorkbook.write(fos);
            }
            System.out.println("Fisierul " + outputPath + " a fost generat cu succes!");

        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }

    public static void insereazaFormulaSiExporta(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Medii Formula");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());

                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());

                    if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    } else if (inputCell.getCellType() == CellType.NUMERIC) {
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                    }
                }

                int rowIndex = inputRow.getRowNum();
                Cell formulaCell = outputRow.createCell(6);

                if (rowIndex == 0) {
                    formulaCell.setCellValue("Medie Formula");
                } else {
                    int excelRowNumber = rowIndex + 1;
                    String formula = "AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")";
                    formulaCell.setCellFormula(formula);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                outputWorkbook.write(fos);
            }
            System.out.println("Fisierul " + outputPath + " a fost generat cu formula cu succes!");

        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}