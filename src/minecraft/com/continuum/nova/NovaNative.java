package com.continuum.nova;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

/**
 * Provides a direct interface into the native code
 *
 * This class is going to be really big. Sorry.
 *
 * @author David
 */
interface NovaNative extends Library {
    NovaNative INSTANCE = (NovaNative) Native.loadLibrary("nova-renderer", NovaNative.class);

    public static class mc_texture extends Structure {
        public int width;
        public int height;
        public int num_components;
        public byte[] texture_data;
        public String name;

        public mc_texture(int width, int height, int num_components, byte[] texture_data, String name) {
            this.width = width;
            this.height = height;
            this.num_components = num_components;
            this.texture_data = texture_data;
            this.name = name;
        }
    }

    void init_nova();

    void add_texture(mc_texture texture);

    void reset_texture_manager();

    void finalize_textures();
}