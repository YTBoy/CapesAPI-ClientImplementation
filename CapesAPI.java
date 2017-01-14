package com.halfpetal.capesapi;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * A simple CapesAPI implementation for Minecraft client developers.
 *
 * @author  Matthew Hatcher
 * @version 1.0.0, January 2017
 */
public class CapesAPI {
  /**
   * Downloads the user's cape from CapesAPI and add it to the skin map.
   *
   * @param  profile The profile to use to grab the cape
   * @param  map     The skin map to apply the cape to
   * @return         The success of skin map application
   */
  public static boolean setCape(GameProfile profile, Map map) {
    try {
      map.put(MinecraftProfileTexture.Type.CAPE, new MinecraftProfileTexture("https://capesapi.com/api/v1/" + profile.getId() + "/getCape", null);
      Runtime.getRuntime().addShutdownHook(new Thread(() -> emptyCache()));
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  /**
   * Clears the player's cape cache.
   */
  public static void emptyCache() {
    try {
      FileUtils.deleteDirectory(new File(Minecraft.getMinecraft().mcDataDir, "assets/skins/"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
