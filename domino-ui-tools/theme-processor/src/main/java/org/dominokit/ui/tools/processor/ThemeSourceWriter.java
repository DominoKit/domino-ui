package org.dominokit.ui.tools.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.dominokit.domino.apt.commons.AbstractSourceBuilder;
import org.dominokit.domino.ui.ColorInfo;
import org.dominokit.domino.ui.ColorsSet;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ThemeSourceWriter extends AbstractSourceBuilder {

    private final String rootPackageName;
    private final Element packageElement;

    protected ThemeSourceWriter(Element packageElement, ProcessingEnvironment processingEnv) {
        super(processingEnv);
        this.packageElement = packageElement;
        this.rootPackageName = elements.getPackageOf(packageElement).getQualifiedName().toString();
    }

    @Override
    public List<TypeSpec.Builder> asTypeBuilder() {
        List<TypeSpec.Builder> types = new ArrayList<>();
        types.addAll(generateColors());
        return types;
    }

    private Collection<? extends TypeSpec.Builder> generateColors() {

        List<TypeSpec.Builder> types = new ArrayList<>();
        ColorsSet colorsSet = packageElement.getAnnotation(ColorsSet.class);
        ColorInfo[] colors = colorsSet.value();

        String colorInterfaceName = processorUtil.capitalizeFirstLetter(colorsSet.name()) + "Color";
        TypeSpec.Builder colorsInterface = TypeSpec.interfaceBuilder(colorInterfaceName);
        TypeSpec.Builder colorsScheme = TypeSpec.interfaceBuilder(processorUtil.capitalizeFirstLetter(colorsSet.name()) + "ColorScheme");

        for (ColorInfo colorInfo : colors) {

            ColorMeta color = new ColorMeta(colorInfo);
            colorsInterface
                    .addField(FieldSpec.builder(Color.class, color.fieldName)
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.NONE))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.L1.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.L1))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.L2.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.L2))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.L3.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.L3))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.L4.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.L4))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.L5.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.L5))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.D1.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.D1))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.D2.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.D2))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.D3.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.D3))
                            .build()
                    )
                    .addField(FieldSpec.builder(Color.class, color.fieldName + ColorShade.D4.asFieldNameExtension())
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorAnonymousClass(color.hex, color, ColorShade.D4))
                            .build()
                    );

            ClassName colorInterfaceType = ClassName.bestGuess(rootPackageName + "." + colorInterfaceName);

            TypeSpec colorSchemeImpl = TypeSpec.anonymousClassBuilder("")
                    .addSuperinterface(ColorScheme.class)
                    .addMethod(MethodSpec.methodBuilder("lighten_5")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.L5.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("lighten_4")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.L4.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("lighten_3")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.L3.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("lighten_2")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.L2.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("lighten_1")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.L1.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("color")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName)
                            .build())
                    .addMethod(MethodSpec.methodBuilder("darker_1")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.D1.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("darker_2")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.D2.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("darker_3")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.D3.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("darker_4")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(Color.class)
                            .addStatement("return $T.$L", colorInterfaceType, color.fieldName + ColorShade.D4.asFieldNameExtension())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("getName")
                            .addModifiers(Modifier.PUBLIC)
                            .returns(String.class)
                            .addStatement("return $S", color.name.toUpperCase())
                            .build())
                    .addMethod(MethodSpec.methodBuilder("rgba_1")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(String.class)
                            .addStatement("return $S", color.rgba_1)
                            .build())
                    .addMethod(MethodSpec.methodBuilder("rgba_2")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(String.class)
                            .addStatement("return $S", color.rgba_2)
                            .build())
                    .build();

            colorsScheme
                    .addField(FieldSpec.builder(ColorScheme.class, color.fieldName)
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("$L", colorSchemeImpl)
                            .build()
                    );

        }
        types.add(colorsInterface);
        types.add(colorsScheme);
        return types;
    }

    private TypeSpec colorAnonymousClass(String hex, ColorMeta color, ColorShade colorShade) {
        TypeSpec colorImpl = TypeSpec.anonymousClassBuilder("")
                .addSuperinterface(Color.class)
                .addMethod(MethodSpec.methodBuilder("getStyle")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return $S", "col-" + colorShade.getStyleExtension() + color.name.toLowerCase())
                        .build())
                .addMethod(MethodSpec.methodBuilder("getName")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return $S", color.name.toUpperCase() + colorShade.getNameExtension())
                        .build())
                .addMethod(MethodSpec.methodBuilder("getHex")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return $S", hex)
                        .build())
                .addMethod(MethodSpec.methodBuilder("getBackground")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return $S", "bg-" + colorShade.getStyleExtension() + color.name.toLowerCase())
                        .build())
                .build();
        return colorImpl;
    }
}
