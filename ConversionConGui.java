import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionConGui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Conversor de Bases Numéricas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 2, 10, 10));

            JLabel etiquetaEntrada = new JLabel("Ingrese un número:");
            JTextField campoEntrada = new JTextField();
            JLabel etiquetaResultado = new JLabel("Resultado:");
            JTextField campoResultado = new JTextField();
            campoResultado.setEditable(false);

            JButton binarioADecimal = new JButton("Binario a Decimal");
            JButton binarioAHexadecimal = new JButton("Binario a Hexadecimal");
            JButton decimalABinario = new JButton("Decimal a Binario");
            JButton decimalAHexadecimal = new JButton("Decimal a Hexadecimal");
            JButton hexadecimalABinario = new JButton("Hexadecimal a Binario");
            JButton hexadecimalADecimal = new JButton("Hexadecimal a Decimal");

            frame.add(etiquetaEntrada);
            frame.add(campoEntrada);
            frame.add(etiquetaResultado);
            frame.add(campoResultado);
            frame.add(binarioADecimal);
            frame.add(binarioAHexadecimal);
            frame.add(decimalABinario);
            frame.add(decimalAHexadecimal);
            frame.add(hexadecimalABinario);
            frame.add(hexadecimalADecimal);

            frame.pack();
            frame.setVisible(true);

            binarioADecimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String entrada = campoEntrada.getText();
                        if (entrada.matches("^[01]+$")) {
                            int decimal = convertirBinarioADecimal(entrada, 0, 0);
                            campoResultado.setText(Integer.toString(decimal));
                        } else {
                            mostrarError("Número binario no válido. Debe contener solo 0 y 1.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número binario no válido.");
                    }
                }
            });

            binarioAHexadecimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String entrada = campoEntrada.getText();
                        if (entrada.matches("^[01]+$")) {
                            String hexadecimal = convertirBinarioAHexadecimal(entrada, 0, "");
                            campoResultado.setText(hexadecimal);
                        } else {
                            mostrarError("Número binario no válido. Debe contener solo 0 y 1.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número binario no válido.");
                    }
                }
            });

            decimalABinario.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String entrada = campoEntrada.getText();
                        if (entrada.matches("^[0-9]+$")) {
                            int decimal = Integer.parseInt(entrada);
                            String binario = convertirDecimalABinario(decimal, "");
                            campoResultado.setText(binario);
                        } else {
                            mostrarError("Número decimal no válido. Debe contener solo dígitos decimales.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número decimal no válido.");
                    }
                }
            });

            decimalAHexadecimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String entrada = campoEntrada.getText();
                        if (entrada.matches("^[0-9]+$")) {
                            int decimal = Integer.parseInt(entrada);
                            String hexadecimal = convertirDecimalAHexadecimal(decimal, "");
                            campoResultado.setText(hexadecimal);
                        } else {
                            mostrarError("Número decimal no válido. Debe contener solo dígitos decimales.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número decimal no válido.");
                    }
                }
            });

            hexadecimalABinario.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String entrada = campoEntrada.getText();
                    try {
                        if (entrada.matches("^[0-9A-F]+$")) {
                            String binario = convertirHexadecimalABinario(entrada, 0, "");
                            campoResultado.setText(binario);
                        } else {
                            mostrarError("Número hexadecimal no válido. Debe contener solo dígitos y letras mayúsculas A-F.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número hexadecimal no válido.");
                    }
                }
            });

            hexadecimalADecimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String entrada = campoEntrada.getText();
                        if (entrada.matches("^[0-9A-F]+$")) {
                            int decimal = convertirHexadecimalADecimal(entrada, entrada.length() - 1, 0);
                            campoResultado.setText(Integer.toString(decimal));
                        } else {
                            mostrarError("Número hexadecimal no válido. Debe contener solo dígitos y letras mayúsculas A-F.");
                        }
                    } catch (NumberFormatException ex) {
                        mostrarError("Número hexadecimal no válido.");
                    }
                }
            });
        });
    }

    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static int convertirBinarioADecimal(String binario, int indice, int decimal) {
        if (indice < 0) {
            return decimal;
        }
        int bit = Character.getNumericValue(binario.charAt(indice));
        return convertirBinarioADecimal(binario, indice - 1, decimal + bit * (int) Math.pow(2, binario.length() - 1 - indice));
    }

    public static String convertirBinarioAHexadecimal(String binario, int indice, String hexadecimal) {
        if (indice < binario.length()) {
            String digitoBinario = binario.substring(indice, indice + 4);
            int valorDecimal = Integer.parseInt(digitoBinario, 2);
            char digitoHex = "0123456789ABCDEF".charAt(valorDecimal);
            return convertirBinarioAHexadecimal(binario, indice + 4, hexadecimal + digitoHex);
        } else {
            return hexadecimal;
        }
    }

    public static String convertirDecimalABinario(int decimal, String binario) {
        if (decimal == 0) {
            return binario;
        } else {
            int bit = decimal % 2;
            return convertirDecimalABinario(decimal / 2, bit + binario);
        }
    }

    public static String convertirDecimalAHexadecimal(int decimal, String hexadecimal) {
        if (decimal == 0) {
            return hexadecimal;
        } else {
            int residuo = decimal % 16;
            char digitoHex = "0123456789ABCDEF".charAt(residuo);
            return convertirDecimalAHexadecimal(decimal / 16, digitoHex + hexadecimal);
        }
    }

    public static String convertirHexadecimalABinario(String hexadecimal, int indice, String binario) {
        if (indice < hexadecimal.length()) {
            char digitoHex = hexadecimal.charAt(indice);
            int valor = Integer.parseInt(String.valueOf(digitoHex), 16);
            String digitoBinario = String.format("%4s", Integer.toBinaryString(valor)).replace(' ', '0');
            return convertirHexadecimalABinario(hexadecimal, indice + 1, binario + digitoBinario);
        } else {
            return binario;
        }
    }

    public static int convertirHexadecimalADecimal(String hexadecimal, int indice, int decimal) {
        if (indice < 0) {
            return decimal;
        }
        String digitosHex = "0123456789ABCDEF";
        char digito = hexadecimal.charAt(indice);
        int valor = digitosHex.indexOf(digito);
        return convertirHexadecimalADecimal(hexadecimal, indice - 1, decimal + valor * (int) Math.pow(16, hexadecimal.length() - 1 - indice));
    }
}
