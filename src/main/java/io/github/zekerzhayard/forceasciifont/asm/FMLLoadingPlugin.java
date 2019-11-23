package io.github.zekerzhayard.forceasciifont.asm;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("ForceAsciiFont")
public class FMLLoadingPlugin implements IFMLLoadingPlugin {
    public static boolean runtimeDeobfuscationEnabled = true;

    @Override
    public String[] getASMTransformerClass() {
        return new String[] {
            "io.github.zekerzhayard.forceasciifont.asm.ClassTransformer"
        };
    }

    @Override
    public String getModContainerClass() {
        return "io.github.zekerzhayard.forceasciifont.ForceAsciiFont";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        runtimeDeobfuscationEnabled = (boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
