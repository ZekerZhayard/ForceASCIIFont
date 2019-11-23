package io.github.zekerzhayard.forceasciifont;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.versioning.InvalidVersionSpecificationException;
import net.minecraftforge.fml.common.versioning.VersionRange;
import net.minecraftforge.fml.relauncher.Side;

public class ForceAsciiFont extends DummyModContainer {
    public ForceAsciiFont() {
        super(new ModMetadata());
        ModMetadata md = this.getMetadata();
        md.modId = "forceasciifont";
        md.name = "ForceAsciiFont";
        md.version = "@VERSION@";
        md.url = "https://www.curseforge.com/minecraft/mc-mods/forceasciifont";
        md.authorList.add("ZekerZhayard");
        md.description = "Force ASCII fonts.";
        md.updateJSON = "https://raw.githubusercontent.com/ZekerZhayard/ForceASCIIFont/master/update.json";
    }

    @Override
    public File getSource() {
        return new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        return true;
    }

    @Override
    public boolean matches(Object mod) {
        return this.equals(mod);
    }

    @Override
    public Object getMod() {
        return this;
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        try {
            return VersionRange.createFromVersionSpec("[1.8,1.12.2]");
        } catch (InvalidVersionSpecificationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, String> getSharedModDescriptor() {
        Map<String, String> descriptor = Maps.newHashMap();
        descriptor.put("modsystem", "FML");
        descriptor.put("id", getModId());
        descriptor.put("version", getDisplayVersion());
        descriptor.put("name", getName());
        descriptor.put("url", this.getMetadata().url);
        descriptor.put("authors", this.getMetadata().getAuthorList());
        descriptor.put("description", this.getMetadata().description);
        return descriptor;
    }

    @Override
    public boolean shouldLoadInEnvironment() {
        return FMLCommonHandler.instance().getSide().equals(Side.CLIENT);
    }

    @Override
    public URL getUpdateUrl() {
        try {
            return new URL(this.getMetadata().updateJSON);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
