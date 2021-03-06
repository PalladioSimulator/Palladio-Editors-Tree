package org.palladiosimulator.pcm.system.presentation;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Customized version of {@link SystemEditorGen}.
 */
public class SystemEditor extends SystemEditorGen {

    /**
     * {@inheritDoc}
     */
    @Override
    public void createModel() {
        super.createModel();
        addExtraResource("pathmap://PCM_MODELS/PrimitiveTypes.repository");
        addExtraResource("pathmap://PCM_MODELS/Palladio.resourcetype");
        addExtraResource("pathmap://PCM_MODELS/FailureTypes.repository");
    }

    /**
     * Adds the extra resource.
     *
     * @param uri
     *            the uri
     */
    private void addExtraResource(final String uri) {
        final Resource extraResource = this.editingDomain.getResourceSet()
            .getResource(URI.createURI(uri), true);
        try {
            extraResource.load(new HashMap<Object, Object>());
        } catch (final IOException e) {
            // FIXME: Empty catch block!
        }
    }
}
